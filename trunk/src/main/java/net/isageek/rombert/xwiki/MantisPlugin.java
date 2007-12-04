package net.isageek.rombert.xwiki;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import net.isageek.rombert.xwiki.mantis.Issue;
import net.isageek.rombert.xwiki.mantis.IssueLister;
import net.isageek.rombert.xwiki.mantis.dao.DAOFactory;
import net.isageek.rombert.xwiki.mantis.dao.FilterDAO;
import net.isageek.rombert.xwiki.mantis.dao.IssueDAO;
import net.isageek.rombert.xwiki.mantis.dao.ProjectDAO;

import biz.futureware.mantisconnect.MantisConnectLocator;
import biz.futureware.mantisconnect.MantisConnectPortType;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.api.Api;
import com.xpn.xwiki.plugin.XWikiDefaultPlugin;
import com.xpn.xwiki.plugin.XWikiPluginInterface;

public class MantisPlugin extends XWikiDefaultPlugin {

    // --------------------------------------------------------------------------------------------
    // Instance fields
    // --------------------------------------------------------------------------------------------

    private String _mantisUsername;
    private String _mantisPassword;
    private String _mantisEndpoint;
    private String _mantisIssueLink;

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public MantisPlugin(String name, String className, XWikiContext context) {

        super(name, className, context);
        init(context);

    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    @Override
    public void init(XWikiContext context) {

        _mantisUsername = context.getWiki().Param("xwiki.plugin.mantis.username");
        _mantisPassword = context.getWiki().Param("xwiki.plugin.mantis.password");
        _mantisEndpoint = context.getWiki().Param("xwiki.plugin.mantis.endpoint");
        _mantisIssueLink = context.getWiki().Param("xwiki.plugin.mantis.issueLink");
    }

    /* ----------------------------------------------------------------------------------------- */

    @Override
    public String getName() {

        return "mantis";
    }

    /* ----------------------------------------------------------------------------------------- */

    @Override
    public Api getPluginApi(XWikiPluginInterface plugin, XWikiContext context) {

        return new MantisPluginApi((MantisPlugin) plugin, context);
    }

    /* ----------------------------------------------------------------------------------------- */

    public String listIssues(String projectName, String filterName) throws RemoteException, ServiceException, MalformedURLException {

        MantisConnectLocator locator = new MantisConnectLocator();
        MantisConnectPortType mantisConnectPort = locator.getMantisConnectPort(new URL(_mantisEndpoint));

        DAOFactory factory = new DAOFactory(mantisConnectPort, _mantisUsername, _mantisPassword);

        ProjectDAO projectDAO = factory.getProjectDAO();
        FilterDAO filterDAO = factory.getFilterDAO();
        IssueDAO issueDAO = factory.getIssueDAO();

        IssueLister issueLister = new IssueLister(projectDAO, filterDAO, issueDAO);

        List<Issue> issues = issueLister.listIssues(projectName, filterName);

        StringBuilder builder = new StringBuilder();

        builder.append("{table}");
        builder.append(" *Id* | *Issue* | *Status* | *Assignee* ");
        endRow(builder);

        for (Issue issue : issues) {
            cell(builder, issue.getId());
            String nameWithLink = "[" + issue.getName() + " > " + _mantisIssueLink + issue.getId() + "]";
            cell(builder, nameWithLink);
            cell(builder, issue.getStatus());
            cell(builder, issue.getAssignee());
            endRow(builder);
        }

        builder.append("{table}");

        return builder.toString();
    }

    /* ----------------------------------------------------------------------------------------- */

    private void endRow(StringBuilder builder) {

        builder.append(System.getProperty("line.separator"));
    }

    /* ----------------------------------------------------------------------------------------- */

    private StringBuilder cell(StringBuilder builder, Object value) {

        String toAppend = value == null ? "" : value.toString();

        return builder.append(toAppend).append("|");
    }

    /* ----------------------------------------------------------------------------------------- */

}

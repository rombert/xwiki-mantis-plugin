package net.isageek.rombert.xwiki;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.api.Api;

public class MantisPluginApi extends Api {

    // --------------------------------------------------------------------------------------------
    // Instance fields
    // --------------------------------------------------------------------------------------------

    private final MantisPlugin _plugin;

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public MantisPluginApi(MantisPlugin plugin, XWikiContext xwikiContext) {

        super(xwikiContext);

        _plugin = plugin;

    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    public MantisPlugin getPlugin() {

        return (hasProgrammingRights() ? _plugin : null);
    }

    /* ----------------------------------------------------------------------------------------- */

    public String listIssues(String projectName, String filterName) throws RemoteException, ServiceException, MalformedURLException {

        return _plugin.listIssues(projectName, filterName);
    }

    /* ----------------------------------------------------------------------------------------- */

}

package net.isageek.rombert.xwiki.mantis;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

import net.isageek.rombert.xwiki.mantis.dao.FilterDAO;
import net.isageek.rombert.xwiki.mantis.dao.IssueDAO;
import net.isageek.rombert.xwiki.mantis.dao.ProjectDAO;


/**
 * List issues from the Mantis bug tracking system
 * 
 * @author Robert Munteanu
 */
public class IssueLister {

    // --------------------------------------------------------------------------------------------
    // Instance fields
    // --------------------------------------------------------------------------------------------

    private final ProjectDAO _projectDAO;
    private final FilterDAO _filterDAO;
    private final IssueDAO _issueDAO;

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public IssueLister(ProjectDAO projectDAO, FilterDAO filterDAO, IssueDAO issueDAO) {

        _projectDAO = projectDAO;
        _filterDAO = filterDAO;
        _issueDAO = issueDAO;

    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    public List<Issue> listIssues(String project, String filterName) throws RemoteException {

        BigInteger projectId = _projectDAO.getByName(project);
        BigInteger filterId = _filterDAO.getByProjectIdAndName(projectId, filterName);

        return _issueDAO.getIssues(projectId, filterId);

    }

    /* ----------------------------------------------------------------------------------------- */

}

package net.isageek.rombert.xwiki.mantis.dao;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import net.isageek.rombert.xwiki.mantis.Issue;

import biz.futureware.mantisconnect.IssueHeaderData;
import biz.futureware.mantisconnect.MantisConnectPortType;


public class IssueDAO {

    // --------------------------------------------------------------------------------------------
    // Instance fields
    // --------------------------------------------------------------------------------------------

    private final String _password;
    private final String _username;
    private final MantisConnectPortType _mantisConnectPortType;
    private final StatusDAO _statusDAO;
    private final UserDAO _userDAO;

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public IssueDAO(MantisConnectPortType mantisConnectPortType, String username, String password, StatusDAO statusDAO, UserDAO userDAO) {

        _mantisConnectPortType = mantisConnectPortType;
        _username = username;
        _password = password;
        _statusDAO = statusDAO;
        _userDAO = userDAO;
    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    public List<Issue> getIssues(BigInteger projectId, BigInteger filterId) throws RemoteException {

        List<Issue> issues = new ArrayList<Issue>();
        IssueHeaderData[] headers = _mantisConnectPortType.mc_filter_get_issue_headers(_username, _password, projectId, filterId, BigInteger.ZERO, BigInteger.valueOf(Long.MAX_VALUE));
        for (IssueHeaderData issueHeaderData : headers) {
            String status = _statusDAO.getById(issueHeaderData.getStatus());
            String handler = _userDAO.getById(issueHeaderData.getHandler());

            issues.add(new Issue(issueHeaderData.getId(), issueHeaderData.getSummary(), handler, status));
        }

        return issues;
    }

    /* ----------------------------------------------------------------------------------------- */

}

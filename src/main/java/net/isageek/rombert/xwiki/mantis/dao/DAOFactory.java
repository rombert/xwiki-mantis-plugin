package net.isageek.rombert.xwiki.mantis.dao;

import java.rmi.RemoteException;

import biz.futureware.mantisconnect.MantisConnectPortType;

public class DAOFactory {

    // --------------------------------------------------------------------------------------------
    // Instance fields
    // --------------------------------------------------------------------------------------------

    private final MantisConnectPortType _mantisConnectPortType;
    private final String _username;
    private final String _password;

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public DAOFactory(MantisConnectPortType mantisConnectPortType, String username, String password) {

        _mantisConnectPortType = mantisConnectPortType;
        _username = username;
        _password = password;
    }

    // --------------------------------------------------------------------------------------------
    // Instance fields
    // --------------------------------------------------------------------------------------------

    public FilterDAO getFilterDAO() {

        return new FilterDAO(_mantisConnectPortType, _username, _password);
    }

    /* ----------------------------------------------------------------------------------------- */

    public UserDAO getUserDAO() throws RemoteException {

        return new UserDAO(_mantisConnectPortType, _username, _password);
    }

    /* ----------------------------------------------------------------------------------------- */

    public StatusDAO getStatusDAO() throws RemoteException {

        return new StatusDAO(_mantisConnectPortType, _username, _password);
    }

    /* ----------------------------------------------------------------------------------------- */

    public ProjectDAO getProjectDAO() throws RemoteException {

        return new ProjectDAO(_mantisConnectPortType, _username, _password);
    }

    /* ----------------------------------------------------------------------------------------- */

    public IssueDAO getIssueDAO() throws RemoteException {

        return new IssueDAO(_mantisConnectPortType, _username, _password, getStatusDAO(), getUserDAO());
    }

    /* ----------------------------------------------------------------------------------------- */

}

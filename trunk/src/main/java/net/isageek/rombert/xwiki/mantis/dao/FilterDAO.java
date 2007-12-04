package net.isageek.rombert.xwiki.mantis.dao;

import java.math.BigInteger;
import java.rmi.RemoteException;

import biz.futureware.mantisconnect.FilterData;
import biz.futureware.mantisconnect.MantisConnectPortType;

public class FilterDAO {

    // --------------------------------------------------------------------------------------------
    // Instance fields
    // --------------------------------------------------------------------------------------------

    private final MantisConnectPortType _mantisConnectPortType;
    private final String _username;
    private final String _password;

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public FilterDAO(MantisConnectPortType mantisConnectPortType, String username, String password) {

        _mantisConnectPortType = mantisConnectPortType;
        _username = username;
        _password = password;

    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    public synchronized BigInteger getByProjectIdAndName(BigInteger projectId, String name) throws RemoteException {

        FilterData[] filters = _mantisConnectPortType.mc_filter_get(_username, _password, projectId);

        for (FilterData filterData : filters)
            if (filterData.getName().equals(name))
                return filterData.getId();

        throw new RuntimeException("Unable to find filter for project with id " + projectId + " by name " + name);

    }

    /* ----------------------------------------------------------------------------------------- */

}

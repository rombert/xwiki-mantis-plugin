package net.isageek.rombert.xwiki.mantis.dao;

import java.math.BigInteger;
import java.rmi.RemoteException;

import biz.futureware.mantisconnect.AccountData;
import biz.futureware.mantisconnect.MantisConnectPortType;

public class UserDAO extends AbstractDAO {

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public UserDAO(MantisConnectPortType mantisConnectPortType, String username, String password) throws RemoteException {

        super(mantisConnectPortType, username, password);
    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    @Override
    protected synchronized void flush() throws RemoteException {

        AccountData[] accountData = _mantisConnectPortType.mc_project_get_users(_username, _password, BigInteger.ONE, BigInteger.ONE);
        for (AccountData ref : accountData) {
            _nameToIdMap.put(ref.getId(), ref.getName());
            _idToNameMap.put(ref.getName(), ref.getId());
        }

    }

    /* ----------------------------------------------------------------------------------------- */

}

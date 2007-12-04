package net.isageek.rombert.xwiki.mantis.dao;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import biz.futureware.mantisconnect.MantisConnectPortType;

public abstract class AbstractDAO {

    // --------------------------------------------------------------------------------------------
    // Instance fields
    // --------------------------------------------------------------------------------------------

    protected final MantisConnectPortType _mantisConnectPortType;
    protected final Map<BigInteger, String> _nameToIdMap = new HashMap<BigInteger, String>();
    protected final Map<String, BigInteger> _idToNameMap = new HashMap<String, BigInteger>();
    protected final String _username;
    protected final String _password;

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public AbstractDAO(MantisConnectPortType mantisConnectPortType, String username, String password) throws RemoteException {

        _mantisConnectPortType = mantisConnectPortType;
        _username = username;
        _password = password;

        flush();

    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    public synchronized String getById(BigInteger id) {

        return _nameToIdMap.get(id);
    }

    /* ----------------------------------------------------------------------------------------- */

    public synchronized BigInteger getByName(String name) {

        BigInteger objectId = _idToNameMap.get(name);

        if (objectId == null)
            throw new RuntimeException("Unable to find object with name " + name);

        return objectId;

    }

    /* ----------------------------------------------------------------------------------------- */

    protected abstract void flush() throws RemoteException;
}

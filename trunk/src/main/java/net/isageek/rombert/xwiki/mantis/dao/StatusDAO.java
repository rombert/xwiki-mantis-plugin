package net.isageek.rombert.xwiki.mantis.dao;

import java.rmi.RemoteException;

import biz.futureware.mantisconnect.MantisConnectPortType;
import biz.futureware.mantisconnect.ObjectRef;

public class StatusDAO extends AbstractDAO {

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public StatusDAO(MantisConnectPortType mantisConnectPortType, String username, String password) throws RemoteException {

        super(mantisConnectPortType, username, password);
    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    @Override
    protected synchronized void flush() throws RemoteException {

        ObjectRef[] stati = _mantisConnectPortType.mc_enum_status(_username, _password);
        for (ObjectRef ref : stati) {
            _nameToIdMap.put(ref.getId(), ref.getName());
            _idToNameMap.put(ref.getName(), ref.getId());
        }

    }

    /* ----------------------------------------------------------------------------------------- */

}

package net.isageek.rombert.xwiki.mantis.dao;

import java.rmi.RemoteException;

import biz.futureware.mantisconnect.MantisConnectPortType;
import biz.futureware.mantisconnect.ProjectData;

public class ProjectDAO extends AbstractDAO {

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public ProjectDAO(MantisConnectPortType mantisConnectPortType, String username, String password) throws RemoteException {

        super(mantisConnectPortType, username, password);
    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    @Override
    protected synchronized void flush() throws RemoteException {

        ProjectData[] users = _mantisConnectPortType.mc_projects_get_user_accessible(_username, _password);
        for (ProjectData ref : users) {
            _nameToIdMap.put(ref.getId(), ref.getName());
            _idToNameMap.put(ref.getName(), ref.getId());
        }

    }

    /* ----------------------------------------------------------------------------------------- */

}

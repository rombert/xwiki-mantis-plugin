package net.isageek.rombert.xwiki.mantis;

import java.math.BigInteger;

/**
 * Represents an issue in the Mantis bug tracking system
 * 
 * @author Robert Munteanu
 *
 */
public class Issue {

    // --------------------------------------------------------------------------------------------
    // Instance fields
    // --------------------------------------------------------------------------------------------

    private final String _assignee;
    private final String _name;
    private final BigInteger _id;
    private final String _status;

    // --------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------

    public Issue(BigInteger bigInteger, String name, String assignee, String status) {

        _id = bigInteger;
        _assignee = assignee;
        _name = name;
        _status = status;
    }

    // --------------------------------------------------------------------------------------------
    // Instance methods
    // --------------------------------------------------------------------------------------------

    public BigInteger getId() {

        return _id;
    }

    /* ----------------------------------------------------------------------------------------- */

    public String getName() {

        return _name;
    }

    /* ----------------------------------------------------------------------------------------- */

    public String getAssignee() {

        return _assignee;
    }

    /* ----------------------------------------------------------------------------------------- */

    public String getStatus() {

        return _status;
    }

    /* ----------------------------------------------------------------------------------------- */

}

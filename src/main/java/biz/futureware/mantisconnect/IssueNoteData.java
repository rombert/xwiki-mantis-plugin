/**
 * IssueNoteData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package biz.futureware.mantisconnect;

public class IssueNoteData  implements java.io.Serializable {
    private java.math.BigInteger id;

    private biz.futureware.mantisconnect.AccountData reporter;

    private java.lang.String text;

    private biz.futureware.mantisconnect.ObjectRef view_state;

    private java.util.Calendar date_submitted;

    private java.util.Calendar last_modified;

    public IssueNoteData() {
    }

    public IssueNoteData(
           java.math.BigInteger id,
           biz.futureware.mantisconnect.AccountData reporter,
           java.lang.String text,
           biz.futureware.mantisconnect.ObjectRef view_state,
           java.util.Calendar date_submitted,
           java.util.Calendar last_modified) {
           this.id = id;
           this.reporter = reporter;
           this.text = text;
           this.view_state = view_state;
           this.date_submitted = date_submitted;
           this.last_modified = last_modified;
    }


    /**
     * Gets the id value for this IssueNoteData.
     * 
     * @return id
     */
    public java.math.BigInteger getId() {
        return id;
    }


    /**
     * Sets the id value for this IssueNoteData.
     * 
     * @param id
     */
    public void setId(java.math.BigInteger id) {
        this.id = id;
    }


    /**
     * Gets the reporter value for this IssueNoteData.
     * 
     * @return reporter
     */
    public biz.futureware.mantisconnect.AccountData getReporter() {
        return reporter;
    }


    /**
     * Sets the reporter value for this IssueNoteData.
     * 
     * @param reporter
     */
    public void setReporter(biz.futureware.mantisconnect.AccountData reporter) {
        this.reporter = reporter;
    }


    /**
     * Gets the text value for this IssueNoteData.
     * 
     * @return text
     */
    public java.lang.String getText() {
        return text;
    }


    /**
     * Sets the text value for this IssueNoteData.
     * 
     * @param text
     */
    public void setText(java.lang.String text) {
        this.text = text;
    }


    /**
     * Gets the view_state value for this IssueNoteData.
     * 
     * @return view_state
     */
    public biz.futureware.mantisconnect.ObjectRef getView_state() {
        return view_state;
    }


    /**
     * Sets the view_state value for this IssueNoteData.
     * 
     * @param view_state
     */
    public void setView_state(biz.futureware.mantisconnect.ObjectRef view_state) {
        this.view_state = view_state;
    }


    /**
     * Gets the date_submitted value for this IssueNoteData.
     * 
     * @return date_submitted
     */
    public java.util.Calendar getDate_submitted() {
        return date_submitted;
    }


    /**
     * Sets the date_submitted value for this IssueNoteData.
     * 
     * @param date_submitted
     */
    public void setDate_submitted(java.util.Calendar date_submitted) {
        this.date_submitted = date_submitted;
    }


    /**
     * Gets the last_modified value for this IssueNoteData.
     * 
     * @return last_modified
     */
    public java.util.Calendar getLast_modified() {
        return last_modified;
    }


    /**
     * Sets the last_modified value for this IssueNoteData.
     * 
     * @param last_modified
     */
    public void setLast_modified(java.util.Calendar last_modified) {
        this.last_modified = last_modified;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IssueNoteData)) return false;
        IssueNoteData other = (IssueNoteData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.reporter==null && other.getReporter()==null) || 
             (this.reporter!=null &&
              this.reporter.equals(other.getReporter()))) &&
            ((this.text==null && other.getText()==null) || 
             (this.text!=null &&
              this.text.equals(other.getText()))) &&
            ((this.view_state==null && other.getView_state()==null) || 
             (this.view_state!=null &&
              this.view_state.equals(other.getView_state()))) &&
            ((this.date_submitted==null && other.getDate_submitted()==null) || 
             (this.date_submitted!=null &&
              this.date_submitted.equals(other.getDate_submitted()))) &&
            ((this.last_modified==null && other.getLast_modified()==null) || 
             (this.last_modified!=null &&
              this.last_modified.equals(other.getLast_modified())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getReporter() != null) {
            _hashCode += getReporter().hashCode();
        }
        if (getText() != null) {
            _hashCode += getText().hashCode();
        }
        if (getView_state() != null) {
            _hashCode += getView_state().hashCode();
        }
        if (getDate_submitted() != null) {
            _hashCode += getDate_submitted().hashCode();
        }
        if (getLast_modified() != null) {
            _hashCode += getLast_modified().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IssueNoteData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://futureware.biz/mantisconnect", "IssueNoteData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reporter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reporter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://futureware.biz/mantisconnect", "AccountData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text");
        elemField.setXmlName(new javax.xml.namespace.QName("", "text"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("view_state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "view_state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://futureware.biz/mantisconnect", "ObjectRef"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_submitted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date_submitted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("last_modified");
        elemField.setXmlName(new javax.xml.namespace.QName("", "last_modified"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

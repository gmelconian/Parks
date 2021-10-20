package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtTransactionContext extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtTransactionContext( )
   {
      this(  new ModelContext(SdtTransactionContext.class));
   }

   public SdtTransactionContext( ModelContext context )
   {
      super( context, "SdtTransactionContext");
   }

   public SdtTransactionContext( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtTransactionContext");
   }

   public SdtTransactionContext( StructSdtTransactionContext struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CallerObject") )
            {
               gxTv_SdtTransactionContext_Callerobject = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CallerOnDelete") )
            {
               gxTv_SdtTransactionContext_Callerondelete = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CallerURL") )
            {
               gxTv_SdtTransactionContext_Callerurl = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TransactionName") )
            {
               gxTv_SdtTransactionContext_Transactionname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Attributes") )
            {
               if ( gxTv_SdtTransactionContext_Attributes == null )
               {
                  gxTv_SdtTransactionContext_Attributes = new GXBaseCollection<com.parks.SdtTransactionContext_Attribute>(com.parks.SdtTransactionContext_Attribute.class, "TransactionContext.Attribute", "Parks", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtTransactionContext_Attributes.readxmlcollection(oReader, "Attributes", "Attribute") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Attributes") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "TransactionContext" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "Parks" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CallerObject", GXutil.rtrim( gxTv_SdtTransactionContext_Callerobject));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("CallerOnDelete", GXutil.rtrim( GXutil.booltostr( gxTv_SdtTransactionContext_Callerondelete)));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("CallerURL", GXutil.rtrim( gxTv_SdtTransactionContext_Callerurl));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("TransactionName", GXutil.rtrim( gxTv_SdtTransactionContext_Transactionname));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      if ( gxTv_SdtTransactionContext_Attributes != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Parks") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Parks" ;
         }
         else
         {
            sNameSpace1 = "Parks" ;
         }
         gxTv_SdtTransactionContext_Attributes.writexmlcollection(oWriter, "Attributes", sNameSpace1, "Attribute", sNameSpace1);
      }
      oWriter.writeEndElement();
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CallerObject", gxTv_SdtTransactionContext_Callerobject, false, false);
      AddObjectProperty("CallerOnDelete", gxTv_SdtTransactionContext_Callerondelete, false, false);
      AddObjectProperty("CallerURL", gxTv_SdtTransactionContext_Callerurl, false, false);
      AddObjectProperty("TransactionName", gxTv_SdtTransactionContext_Transactionname, false, false);
      if ( gxTv_SdtTransactionContext_Attributes != null )
      {
         AddObjectProperty("Attributes", gxTv_SdtTransactionContext_Attributes, false, false);
      }
   }

   public String getgxTv_SdtTransactionContext_Callerobject( )
   {
      return gxTv_SdtTransactionContext_Callerobject ;
   }

   public void setgxTv_SdtTransactionContext_Callerobject( String value )
   {
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Callerobject = value ;
   }

   public boolean getgxTv_SdtTransactionContext_Callerondelete( )
   {
      return gxTv_SdtTransactionContext_Callerondelete ;
   }

   public void setgxTv_SdtTransactionContext_Callerondelete( boolean value )
   {
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Callerondelete = value ;
   }

   public String getgxTv_SdtTransactionContext_Callerurl( )
   {
      return gxTv_SdtTransactionContext_Callerurl ;
   }

   public void setgxTv_SdtTransactionContext_Callerurl( String value )
   {
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Callerurl = value ;
   }

   public String getgxTv_SdtTransactionContext_Transactionname( )
   {
      return gxTv_SdtTransactionContext_Transactionname ;
   }

   public void setgxTv_SdtTransactionContext_Transactionname( String value )
   {
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Transactionname = value ;
   }

   public GXBaseCollection<com.parks.SdtTransactionContext_Attribute> getgxTv_SdtTransactionContext_Attributes( )
   {
      if ( gxTv_SdtTransactionContext_Attributes == null )
      {
         gxTv_SdtTransactionContext_Attributes = new GXBaseCollection<com.parks.SdtTransactionContext_Attribute>(com.parks.SdtTransactionContext_Attribute.class, "TransactionContext.Attribute", "Parks", remoteHandle);
      }
      gxTv_SdtTransactionContext_Attributes_N = (byte)(0) ;
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      return gxTv_SdtTransactionContext_Attributes ;
   }

   public void setgxTv_SdtTransactionContext_Attributes( GXBaseCollection<com.parks.SdtTransactionContext_Attribute> value )
   {
      gxTv_SdtTransactionContext_Attributes_N = (byte)(0) ;
      gxTv_SdtTransactionContext_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Attributes = value ;
   }

   public void setgxTv_SdtTransactionContext_Attributes_SetNull( )
   {
      gxTv_SdtTransactionContext_Attributes_N = (byte)(1) ;
      gxTv_SdtTransactionContext_Attributes = null ;
   }

   public boolean getgxTv_SdtTransactionContext_Attributes_IsNull( )
   {
      if ( gxTv_SdtTransactionContext_Attributes == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtTransactionContext_Attributes_N( )
   {
      return gxTv_SdtTransactionContext_Attributes_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtTransactionContext_Callerobject = "" ;
      gxTv_SdtTransactionContext_N = (byte)(1) ;
      gxTv_SdtTransactionContext_Callerurl = "" ;
      gxTv_SdtTransactionContext_Transactionname = "" ;
      gxTv_SdtTransactionContext_Attributes_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtTransactionContext_N ;
   }

   public com.parks.SdtTransactionContext Clone( )
   {
      return (com.parks.SdtTransactionContext)(clone()) ;
   }

   public void setStruct( com.parks.StructSdtTransactionContext struct )
   {
      setgxTv_SdtTransactionContext_Callerobject(struct.getCallerobject());
      setgxTv_SdtTransactionContext_Callerondelete(struct.getCallerondelete());
      setgxTv_SdtTransactionContext_Callerurl(struct.getCallerurl());
      setgxTv_SdtTransactionContext_Transactionname(struct.getTransactionname());
      GXBaseCollection<com.parks.SdtTransactionContext_Attribute> gxTv_SdtTransactionContext_Attributes_aux = new GXBaseCollection<com.parks.SdtTransactionContext_Attribute>(com.parks.SdtTransactionContext_Attribute.class, "TransactionContext.Attribute", "Parks", remoteHandle);
      Vector<com.parks.StructSdtTransactionContext_Attribute> gxTv_SdtTransactionContext_Attributes_aux1 = struct.getAttributes();
      if (gxTv_SdtTransactionContext_Attributes_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtTransactionContext_Attributes_aux1.size(); i++)
         {
            gxTv_SdtTransactionContext_Attributes_aux.add(new com.parks.SdtTransactionContext_Attribute(gxTv_SdtTransactionContext_Attributes_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtTransactionContext_Attributes(gxTv_SdtTransactionContext_Attributes_aux);
   }

   @SuppressWarnings("unchecked")
   public com.parks.StructSdtTransactionContext getStruct( )
   {
      com.parks.StructSdtTransactionContext struct = new com.parks.StructSdtTransactionContext ();
      struct.setCallerobject(getgxTv_SdtTransactionContext_Callerobject());
      struct.setCallerondelete(getgxTv_SdtTransactionContext_Callerondelete());
      struct.setCallerurl(getgxTv_SdtTransactionContext_Callerurl());
      struct.setTransactionname(getgxTv_SdtTransactionContext_Transactionname());
      struct.setAttributes(getgxTv_SdtTransactionContext_Attributes().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtTransactionContext_N ;
   protected byte gxTv_SdtTransactionContext_Attributes_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtTransactionContext_Callerondelete ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtTransactionContext_Callerobject ;
   protected String gxTv_SdtTransactionContext_Callerurl ;
   protected String gxTv_SdtTransactionContext_Transactionname ;
   protected GXBaseCollection<com.parks.SdtTransactionContext_Attribute> gxTv_SdtTransactionContext_Attributes_aux ;
   protected GXBaseCollection<com.parks.SdtTransactionContext_Attribute> gxTv_SdtTransactionContext_Attributes=null ;
}


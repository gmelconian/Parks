package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCategory extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtCategory( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCategory.class));
   }

   public SdtCategory( int remoteHandle ,
                       ModelContext context )
   {
      super( context, "SdtCategory");
      initialize( remoteHandle) ;
   }

   public SdtCategory( int remoteHandle ,
                       StructSdtCategory struct )
   {
      this(remoteHandle);
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

   public void Load( short AV19CategoryId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV19CategoryId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CategoryId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Category");
      metadata.set("BT", "Category");
      metadata.set("PK", "[ \"CategoryId\" ]");
      metadata.set("PKAssigned", "[ \"CategoryId\" ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CategoryId") )
            {
               gxTv_SdtCategory_Categoryid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CategoryName") )
            {
               gxTv_SdtCategory_Categoryname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCategory_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCategory_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CategoryId_Z") )
            {
               gxTv_SdtCategory_Categoryid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CategoryName_Z") )
            {
               gxTv_SdtCategory_Categoryname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CategoryId_N") )
            {
               gxTv_SdtCategory_Categoryid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
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
         sName = "Category" ;
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
      oWriter.writeElement("CategoryId", GXutil.trim( GXutil.str( gxTv_SdtCategory_Categoryid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("CategoryName", GXutil.rtrim( gxTv_SdtCategory_Categoryname));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtCategory_Mode));
         if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Parks");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCategory_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Parks");
         }
         oWriter.writeElement("CategoryId_Z", GXutil.trim( GXutil.str( gxTv_SdtCategory_Categoryid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Parks");
         }
         oWriter.writeElement("CategoryName_Z", GXutil.rtrim( gxTv_SdtCategory_Categoryname_Z));
         if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Parks");
         }
         oWriter.writeElement("CategoryId_N", GXutil.trim( GXutil.str( gxTv_SdtCategory_Categoryid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Parks");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
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
      AddObjectProperty("CategoryId", gxTv_SdtCategory_Categoryid, false, includeNonInitialized);
      AddObjectProperty("CategoryId_N", gxTv_SdtCategory_Categoryid_N, false, includeNonInitialized);
      AddObjectProperty("CategoryName", gxTv_SdtCategory_Categoryname, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCategory_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCategory_Initialized, false, includeNonInitialized);
         AddObjectProperty("CategoryId_Z", gxTv_SdtCategory_Categoryid_Z, false, includeNonInitialized);
         AddObjectProperty("CategoryName_Z", gxTv_SdtCategory_Categoryname_Z, false, includeNonInitialized);
         AddObjectProperty("CategoryId_N", gxTv_SdtCategory_Categoryid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.parks.SdtCategory sdt )
   {
      if ( sdt.IsDirty("CategoryId") )
      {
         gxTv_SdtCategory_N = (byte)(0) ;
         gxTv_SdtCategory_Categoryid = sdt.getgxTv_SdtCategory_Categoryid() ;
      }
      if ( sdt.IsDirty("CategoryName") )
      {
         gxTv_SdtCategory_N = (byte)(0) ;
         gxTv_SdtCategory_Categoryname = sdt.getgxTv_SdtCategory_Categoryname() ;
      }
   }

   public short getgxTv_SdtCategory_Categoryid( )
   {
      return gxTv_SdtCategory_Categoryid ;
   }

   public void setgxTv_SdtCategory_Categoryid( short value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      if ( gxTv_SdtCategory_Categoryid != value )
      {
         gxTv_SdtCategory_Mode = "INS" ;
         this.setgxTv_SdtCategory_Categoryid_Z_SetNull( );
         this.setgxTv_SdtCategory_Categoryname_Z_SetNull( );
      }
      SetDirty("Categoryid");
      gxTv_SdtCategory_Categoryid = value ;
   }

   public String getgxTv_SdtCategory_Categoryname( )
   {
      return gxTv_SdtCategory_Categoryname ;
   }

   public void setgxTv_SdtCategory_Categoryname( String value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      SetDirty("Categoryname");
      gxTv_SdtCategory_Categoryname = value ;
   }

   public String getgxTv_SdtCategory_Mode( )
   {
      return gxTv_SdtCategory_Mode ;
   }

   public void setgxTv_SdtCategory_Mode( String value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCategory_Mode = value ;
   }

   public void setgxTv_SdtCategory_Mode_SetNull( )
   {
      gxTv_SdtCategory_Mode = "" ;
   }

   public boolean getgxTv_SdtCategory_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategory_Initialized( )
   {
      return gxTv_SdtCategory_Initialized ;
   }

   public void setgxTv_SdtCategory_Initialized( short value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtCategory_Initialized = value ;
   }

   public void setgxTv_SdtCategory_Initialized_SetNull( )
   {
      gxTv_SdtCategory_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtCategory_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategory_Categoryid_Z( )
   {
      return gxTv_SdtCategory_Categoryid_Z ;
   }

   public void setgxTv_SdtCategory_Categoryid_Z( short value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      SetDirty("Categoryid_Z");
      gxTv_SdtCategory_Categoryid_Z = value ;
   }

   public void setgxTv_SdtCategory_Categoryid_Z_SetNull( )
   {
      gxTv_SdtCategory_Categoryid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtCategory_Categoryid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCategory_Categoryname_Z( )
   {
      return gxTv_SdtCategory_Categoryname_Z ;
   }

   public void setgxTv_SdtCategory_Categoryname_Z( String value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      SetDirty("Categoryname_Z");
      gxTv_SdtCategory_Categoryname_Z = value ;
   }

   public void setgxTv_SdtCategory_Categoryname_Z_SetNull( )
   {
      gxTv_SdtCategory_Categoryname_Z = "" ;
   }

   public boolean getgxTv_SdtCategory_Categoryname_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategory_Categoryid_N( )
   {
      return gxTv_SdtCategory_Categoryid_N ;
   }

   public void setgxTv_SdtCategory_Categoryid_N( byte value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      SetDirty("Categoryid_N");
      gxTv_SdtCategory_Categoryid_N = value ;
   }

   public void setgxTv_SdtCategory_Categoryid_N_SetNull( )
   {
      gxTv_SdtCategory_Categoryid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtCategory_Categoryid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.parks.category_bc obj;
      obj = new com.parks.category_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtCategory_N = (byte)(1) ;
      gxTv_SdtCategory_Categoryname = "" ;
      gxTv_SdtCategory_Mode = "" ;
      gxTv_SdtCategory_Categoryname_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCategory_N ;
   }

   public com.parks.SdtCategory Clone( )
   {
      com.parks.SdtCategory sdt;
      com.parks.category_bc obj;
      sdt = (com.parks.SdtCategory)(clone()) ;
      obj = (com.parks.category_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.parks.StructSdtCategory struct )
   {
      setgxTv_SdtCategory_Categoryid(struct.getCategoryid());
      setgxTv_SdtCategory_Categoryname(struct.getCategoryname());
      setgxTv_SdtCategory_Mode(struct.getMode());
      setgxTv_SdtCategory_Initialized(struct.getInitialized());
      setgxTv_SdtCategory_Categoryid_Z(struct.getCategoryid_Z());
      setgxTv_SdtCategory_Categoryname_Z(struct.getCategoryname_Z());
      setgxTv_SdtCategory_Categoryid_N(struct.getCategoryid_N());
   }

   @SuppressWarnings("unchecked")
   public com.parks.StructSdtCategory getStruct( )
   {
      com.parks.StructSdtCategory struct = new com.parks.StructSdtCategory ();
      struct.setCategoryid(getgxTv_SdtCategory_Categoryid());
      struct.setCategoryname(getgxTv_SdtCategory_Categoryname());
      struct.setMode(getgxTv_SdtCategory_Mode());
      struct.setInitialized(getgxTv_SdtCategory_Initialized());
      struct.setCategoryid_Z(getgxTv_SdtCategory_Categoryid_Z());
      struct.setCategoryname_Z(getgxTv_SdtCategory_Categoryname_Z());
      struct.setCategoryid_N(getgxTv_SdtCategory_Categoryid_N());
      return struct ;
   }

   private byte gxTv_SdtCategory_N ;
   private byte gxTv_SdtCategory_Categoryid_N ;
   private short gxTv_SdtCategory_Categoryid ;
   private short gxTv_SdtCategory_Initialized ;
   private short gxTv_SdtCategory_Categoryid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtCategory_Categoryname ;
   private String gxTv_SdtCategory_Mode ;
   private String gxTv_SdtCategory_Categoryname_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}


package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtProgramNames_ProgramName extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtProgramNames_ProgramName( )
   {
      this(  new ModelContext(SdtProgramNames_ProgramName.class));
   }

   public SdtProgramNames_ProgramName( ModelContext context )
   {
      super( context, "SdtProgramNames_ProgramName");
   }

   public SdtProgramNames_ProgramName( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtProgramNames_ProgramName");
   }

   public SdtProgramNames_ProgramName( StructSdtProgramNames_ProgramName struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") )
            {
               gxTv_SdtProgramNames_ProgramName_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtProgramNames_ProgramName_Description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Link") )
            {
               gxTv_SdtProgramNames_ProgramName_Link = oReader.getValue() ;
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
         sName = "ProgramNames.ProgramName" ;
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
      oWriter.writeElement("Name", GXutil.rtrim( gxTv_SdtProgramNames_ProgramName_Name));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("Description", GXutil.rtrim( gxTv_SdtProgramNames_ProgramName_Description));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("Link", GXutil.rtrim( gxTv_SdtProgramNames_ProgramName_Link));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
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
      AddObjectProperty("Name", gxTv_SdtProgramNames_ProgramName_Name, false, false);
      AddObjectProperty("Description", gxTv_SdtProgramNames_ProgramName_Description, false, false);
      AddObjectProperty("Link", gxTv_SdtProgramNames_ProgramName_Link, false, false);
   }

   public String getgxTv_SdtProgramNames_ProgramName_Name( )
   {
      return gxTv_SdtProgramNames_ProgramName_Name ;
   }

   public void setgxTv_SdtProgramNames_ProgramName_Name( String value )
   {
      gxTv_SdtProgramNames_ProgramName_N = (byte)(0) ;
      gxTv_SdtProgramNames_ProgramName_Name = value ;
   }

   public String getgxTv_SdtProgramNames_ProgramName_Description( )
   {
      return gxTv_SdtProgramNames_ProgramName_Description ;
   }

   public void setgxTv_SdtProgramNames_ProgramName_Description( String value )
   {
      gxTv_SdtProgramNames_ProgramName_N = (byte)(0) ;
      gxTv_SdtProgramNames_ProgramName_Description = value ;
   }

   public String getgxTv_SdtProgramNames_ProgramName_Link( )
   {
      return gxTv_SdtProgramNames_ProgramName_Link ;
   }

   public void setgxTv_SdtProgramNames_ProgramName_Link( String value )
   {
      gxTv_SdtProgramNames_ProgramName_N = (byte)(0) ;
      gxTv_SdtProgramNames_ProgramName_Link = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtProgramNames_ProgramName_Name = "" ;
      gxTv_SdtProgramNames_ProgramName_N = (byte)(1) ;
      gxTv_SdtProgramNames_ProgramName_Description = "" ;
      gxTv_SdtProgramNames_ProgramName_Link = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtProgramNames_ProgramName_N ;
   }

   public com.parks.SdtProgramNames_ProgramName Clone( )
   {
      return (com.parks.SdtProgramNames_ProgramName)(clone()) ;
   }

   public void setStruct( com.parks.StructSdtProgramNames_ProgramName struct )
   {
      setgxTv_SdtProgramNames_ProgramName_Name(struct.getName());
      setgxTv_SdtProgramNames_ProgramName_Description(struct.getDescription());
      setgxTv_SdtProgramNames_ProgramName_Link(struct.getLink());
   }

   @SuppressWarnings("unchecked")
   public com.parks.StructSdtProgramNames_ProgramName getStruct( )
   {
      com.parks.StructSdtProgramNames_ProgramName struct = new com.parks.StructSdtProgramNames_ProgramName ();
      struct.setName(getgxTv_SdtProgramNames_ProgramName_Name());
      struct.setDescription(getgxTv_SdtProgramNames_ProgramName_Description());
      struct.setLink(getgxTv_SdtProgramNames_ProgramName_Link());
      return struct ;
   }

   protected byte gxTv_SdtProgramNames_ProgramName_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtProgramNames_ProgramName_Name ;
   protected String gxTv_SdtProgramNames_ProgramName_Description ;
   protected String gxTv_SdtProgramNames_ProgramName_Link ;
}


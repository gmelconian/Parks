package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtStringConcatenationUnitTestSDT extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtStringConcatenationUnitTestSDT( )
   {
      this(  new ModelContext(SdtStringConcatenationUnitTestSDT.class));
   }

   public SdtStringConcatenationUnitTestSDT( ModelContext context )
   {
      super( context, "SdtStringConcatenationUnitTestSDT");
   }

   public SdtStringConcatenationUnitTestSDT( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle, context, "SdtStringConcatenationUnitTestSDT");
   }

   public SdtStringConcatenationUnitTestSDT( StructSdtStringConcatenationUnitTestSDT struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "TestCaseId") )
            {
               gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "string1") )
            {
               gxTv_SdtStringConcatenationUnitTestSDT_String1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "string2") )
            {
               gxTv_SdtStringConcatenationUnitTestSDT_String2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "concatenation") )
            {
               gxTv_SdtStringConcatenationUnitTestSDT_Concatenation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Expectedconcatenation") )
            {
               gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Msgconcatenation") )
            {
               gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation = oReader.getValue() ;
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
         sName = "StringConcatenationUnitTestSDT" ;
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
      oWriter.writeElement("TestCaseId", GXutil.rtrim( gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("string1", GXutil.rtrim( gxTv_SdtStringConcatenationUnitTestSDT_String1));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("string2", GXutil.rtrim( gxTv_SdtStringConcatenationUnitTestSDT_String2));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("concatenation", GXutil.rtrim( gxTv_SdtStringConcatenationUnitTestSDT_Concatenation));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("Expectedconcatenation", GXutil.rtrim( gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation));
      if ( GXutil.strcmp(sNameSpace, "Parks") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Parks");
      }
      oWriter.writeElement("Msgconcatenation", GXutil.rtrim( gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation));
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
      AddObjectProperty("TestCaseId", gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid, false, false);
      AddObjectProperty("string1", gxTv_SdtStringConcatenationUnitTestSDT_String1, false, false);
      AddObjectProperty("string2", gxTv_SdtStringConcatenationUnitTestSDT_String2, false, false);
      AddObjectProperty("concatenation", gxTv_SdtStringConcatenationUnitTestSDT_Concatenation, false, false);
      AddObjectProperty("Expectedconcatenation", gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation, false, false);
      AddObjectProperty("Msgconcatenation", gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation, false, false);
   }

   public String getgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid ;
   }

   public void setgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid = value ;
   }

   public String getgxTv_SdtStringConcatenationUnitTestSDT_String1( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_String1 ;
   }

   public void setgxTv_SdtStringConcatenationUnitTestSDT_String1( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_String1 = value ;
   }

   public String getgxTv_SdtStringConcatenationUnitTestSDT_String2( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_String2 ;
   }

   public void setgxTv_SdtStringConcatenationUnitTestSDT_String2( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_String2 = value ;
   }

   public String getgxTv_SdtStringConcatenationUnitTestSDT_Concatenation( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_Concatenation ;
   }

   public void setgxTv_SdtStringConcatenationUnitTestSDT_Concatenation( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_Concatenation = value ;
   }

   public String getgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation ;
   }

   public void setgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation = value ;
   }

   public String getgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation ;
   }

   public void setgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(1) ;
      gxTv_SdtStringConcatenationUnitTestSDT_String1 = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_String2 = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_Concatenation = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_N ;
   }

   public com.parks.SdtStringConcatenationUnitTestSDT Clone( )
   {
      return (com.parks.SdtStringConcatenationUnitTestSDT)(clone()) ;
   }

   public void setStruct( com.parks.StructSdtStringConcatenationUnitTestSDT struct )
   {
      setgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid(struct.getTestcaseid());
      setgxTv_SdtStringConcatenationUnitTestSDT_String1(struct.getString1());
      setgxTv_SdtStringConcatenationUnitTestSDT_String2(struct.getString2());
      setgxTv_SdtStringConcatenationUnitTestSDT_Concatenation(struct.getConcatenation());
      setgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation(struct.getExpectedconcatenation());
      setgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation(struct.getMsgconcatenation());
   }

   @SuppressWarnings("unchecked")
   public com.parks.StructSdtStringConcatenationUnitTestSDT getStruct( )
   {
      com.parks.StructSdtStringConcatenationUnitTestSDT struct = new com.parks.StructSdtStringConcatenationUnitTestSDT ();
      struct.setTestcaseid(getgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid());
      struct.setString1(getgxTv_SdtStringConcatenationUnitTestSDT_String1());
      struct.setString2(getgxTv_SdtStringConcatenationUnitTestSDT_String2());
      struct.setConcatenation(getgxTv_SdtStringConcatenationUnitTestSDT_Concatenation());
      struct.setExpectedconcatenation(getgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation());
      struct.setMsgconcatenation(getgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation());
      return struct ;
   }

   protected byte gxTv_SdtStringConcatenationUnitTestSDT_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_String1 ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_String2 ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_Concatenation ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation ;
}


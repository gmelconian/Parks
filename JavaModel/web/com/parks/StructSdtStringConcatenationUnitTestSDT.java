package com.parks ;
import com.genexus.*;

public final  class StructSdtStringConcatenationUnitTestSDT implements Cloneable, java.io.Serializable
{
   public StructSdtStringConcatenationUnitTestSDT( )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_String1 = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_String2 = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_Concatenation = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation = "" ;
      gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getTestcaseid( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid ;
   }

   public void setTestcaseid( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid = value ;
   }

   public String getString1( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_String1 ;
   }

   public void setString1( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_String1 = value ;
   }

   public String getString2( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_String2 ;
   }

   public void setString2( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_String2 = value ;
   }

   public String getConcatenation( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_Concatenation ;
   }

   public void setConcatenation( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_Concatenation = value ;
   }

   public String getExpectedconcatenation( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation ;
   }

   public void setExpectedconcatenation( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation = value ;
   }

   public String getMsgconcatenation( )
   {
      return gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation ;
   }

   public void setMsgconcatenation( String value )
   {
      gxTv_SdtStringConcatenationUnitTestSDT_N = (byte)(0) ;
      gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation = value ;
   }

   protected byte gxTv_SdtStringConcatenationUnitTestSDT_N ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_String1 ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_String2 ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_Concatenation ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_Testcaseid ;
   protected String gxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation ;
}


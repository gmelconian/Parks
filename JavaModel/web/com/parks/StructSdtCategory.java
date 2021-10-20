package com.parks ;
import com.genexus.*;

public final  class StructSdtCategory implements Cloneable, java.io.Serializable
{
   public StructSdtCategory( )
   {
      gxTv_SdtCategory_Categoryname = "" ;
      gxTv_SdtCategory_Mode = "" ;
      gxTv_SdtCategory_Categoryname_Z = "" ;
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

   public short getCategoryid( )
   {
      return gxTv_SdtCategory_Categoryid ;
   }

   public void setCategoryid( short value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      gxTv_SdtCategory_Categoryid = value ;
   }

   public String getCategoryname( )
   {
      return gxTv_SdtCategory_Categoryname ;
   }

   public void setCategoryname( String value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      gxTv_SdtCategory_Categoryname = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCategory_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      gxTv_SdtCategory_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCategory_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      gxTv_SdtCategory_Initialized = value ;
   }

   public short getCategoryid_Z( )
   {
      return gxTv_SdtCategory_Categoryid_Z ;
   }

   public void setCategoryid_Z( short value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      gxTv_SdtCategory_Categoryid_Z = value ;
   }

   public String getCategoryname_Z( )
   {
      return gxTv_SdtCategory_Categoryname_Z ;
   }

   public void setCategoryname_Z( String value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      gxTv_SdtCategory_Categoryname_Z = value ;
   }

   public byte getCategoryid_N( )
   {
      return gxTv_SdtCategory_Categoryid_N ;
   }

   public void setCategoryid_N( byte value )
   {
      gxTv_SdtCategory_N = (byte)(0) ;
      gxTv_SdtCategory_Categoryid_N = value ;
   }

   protected byte gxTv_SdtCategory_Categoryid_N ;
   private byte gxTv_SdtCategory_N ;
   protected short gxTv_SdtCategory_Categoryid ;
   protected short gxTv_SdtCategory_Initialized ;
   protected short gxTv_SdtCategory_Categoryid_Z ;
   protected String gxTv_SdtCategory_Categoryname ;
   protected String gxTv_SdtCategory_Mode ;
   protected String gxTv_SdtCategory_Categoryname_Z ;
}


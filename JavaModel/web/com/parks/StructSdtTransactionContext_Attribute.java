package com.parks ;
import com.genexus.*;

public final  class StructSdtTransactionContext_Attribute implements Cloneable, java.io.Serializable
{
   public StructSdtTransactionContext_Attribute( )
   {
      gxTv_SdtTransactionContext_Attribute_Attributename = "" ;
      gxTv_SdtTransactionContext_Attribute_Attributevalue = "" ;
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

   public String getAttributename( )
   {
      return gxTv_SdtTransactionContext_Attribute_Attributename ;
   }

   public void setAttributename( String value )
   {
      gxTv_SdtTransactionContext_Attribute_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Attribute_Attributename = value ;
   }

   public String getAttributevalue( )
   {
      return gxTv_SdtTransactionContext_Attribute_Attributevalue ;
   }

   public void setAttributevalue( String value )
   {
      gxTv_SdtTransactionContext_Attribute_N = (byte)(0) ;
      gxTv_SdtTransactionContext_Attribute_Attributevalue = value ;
   }

   protected byte gxTv_SdtTransactionContext_Attribute_N ;
   protected String gxTv_SdtTransactionContext_Attribute_Attributename ;
   protected String gxTv_SdtTransactionContext_Attribute_Attributevalue ;
}


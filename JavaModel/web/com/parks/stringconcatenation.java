package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class stringconcatenation extends GXProcedure
{
   public stringconcatenation( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( stringconcatenation.class ), "" );
   }

   public stringconcatenation( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      stringconcatenation.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      stringconcatenation.this.AV9string1 = aP0;
      stringconcatenation.this.AV10string2 = aP1;
      stringconcatenation.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11concatenation = GXutil.concat( AV9string1, AV10string2, "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = stringconcatenation.this.AV11concatenation;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11concatenation = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9string1 ;
   private String AV10string2 ;
   private String AV11concatenation ;
   private String[] aP2 ;
}


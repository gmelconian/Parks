package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class webuitest1 extends GXProcedure
{
   public webuitest1( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( webuitest1.class ), "" );
   }

   public webuitest1( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( gxtest.gxtest.SdtWebdriver aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( gxtest.gxtest.SdtWebdriver aP0 )
   {
      webuitest1.this.AV8driver = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8driver.start();
      AV8driver.go("https://www.google.com.uy");
      AV8driver.pausefor(DecimalUtil.doubleToDec(5));
      AV8driver.end();
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private gxtest.gxtest.SdtWebdriver AV8driver ;
}


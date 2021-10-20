package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.util.*;

public final  class reorg extends GXProcedure
{
   public reorg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reorg.class ), "" );
   }

   public reorg( int remoteHandle ,
                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      if ( previousCheck() )
      {
         executeReorganization( ) ;
      }
   }

   private void FirstActions( )
   {
      /* Load data into tables. */
   }

   public void CreateAmusementParkShow( ) throws SQLException
   {
      String cmdBufferCreate = "";
      String cmdBuffer = "";
      /* Indices for table AmusementParkShow */
      try
      {
         cmdBufferCreate = " CREATE TABLE `AmusementParkShow` (`AmusementParkId` smallint NOT NULL , `ShowId` smallint NOT NULL , PRIMARY KEY(`AmusementParkId`, `ShowId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "AmusementParkShow", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `AmusementParkShow` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "AmusementParkShow", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `AmusementParkShow` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "AmusementParkShow", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `AmusementParkShow` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IAMUSEMENTPARKSHOW1` ON `AmusementParkShow` (`ShowId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IAMUSEMENTPARKSHOW1` ON `AmusementParkShow` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IAMUSEMENTPARKSHOW1` ON `AmusementParkShow` (`ShowId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAmusementParkShowAmusementPark( ) throws SQLException
   {
      String cmdBuffer;
      try
      {
         cmdBuffer = " ALTER TABLE `AmusementParkShow` ADD CONSTRAINT `IAMUSEMENTPARKSHOW2` FOREIGN KEY (`AmusementParkId`) REFERENCES `AmusementPark` (`AmusementParkId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AmusementParkShow` DROP FOREIGN KEY `IAMUSEMENTPARKSHOW2` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AmusementParkShow` ADD CONSTRAINT `IAMUSEMENTPARKSHOW2` FOREIGN KEY (`AmusementParkId`) REFERENCES `AmusementPark` (`AmusementParkId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAmusementParkShowShow( ) throws SQLException
   {
      String cmdBuffer;
      try
      {
         cmdBuffer = " ALTER TABLE `AmusementParkShow` ADD CONSTRAINT `IAMUSEMENTPARKSHOW1` FOREIGN KEY (`ShowId`) REFERENCES `Show` (`ShowId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AmusementParkShow` DROP FOREIGN KEY `IAMUSEMENTPARKSHOW1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AmusementParkShow` ADD CONSTRAINT `IAMUSEMENTPARKSHOW1` FOREIGN KEY (`ShowId`) REFERENCES `Show` (`ShowId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   private void tablesCount( )
   {
   }

   private boolean previousCheck( )
   {
      if ( ! GXReorganization.isResumeMode( ) )
      {
         if ( GXutil.dbmsVersion( context, remoteHandle, "DEFAULT") < 5 )
         {
            GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_bad_DBMS_version", new Object[] {"5"}) ) ;
            return false ;
         }
      }
      if ( ! GXReorganization.mustRunCheck( ) )
      {
         return true ;
      }
      sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
      if ( tableexist("AmusementParkShow",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"AmusementParkShow"}) ) ;
         return false ;
      }
      return true ;
   }

   private boolean tableexist( String sTableName ,
                               String sMySchemaName )
   {
      boolean result;
      result = false ;
      /* Using cursor P00012 */
      pr_default.execute(0, new Object[] {sTableName, sMySchemaName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         tablename = P00012_Atablename[0] ;
         ntablename = P00012_ntablename[0] ;
         schemaname = P00012_Aschemaname[0] ;
         nschemaname = P00012_nschemaname[0] ;
         result = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      return result ;
   }

   private void executeOnlyTablesReorganization( )
   {
      callSubmit( "CreateAmusementParkShow" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AmusementParkShow",""}) ,  1 , new Object[]{ });
   }

   private void executeOnlyRisReorganization( )
   {
      callSubmit( "RIAmusementParkShowAmusementPark" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAMUSEMENTPARKSHOW2`"}) ,  2 , new Object[]{ });
      callSubmit( "RIAmusementParkShowShow" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAMUSEMENTPARKSHOW1`"}) ,  3 , new Object[]{ });
   }

   private void executeTablesReorganization( )
   {
      executeOnlyTablesReorganization( ) ;
      executeOnlyRisReorganization( ) ;
      ReorgSubmitThreadPool.startProcess();
   }

   private void setPrecedence( )
   {
      setPrecedencetables( ) ;
      setPrecedenceris( ) ;
   }

   private void setPrecedencetables( )
   {
      GXReorganization.addMsg( 1 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AmusementParkShow",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateAmusementParkShow" );
   }

   private void setPrecedenceris( )
   {
      GXReorganization.addMsg( 2 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAMUSEMENTPARKSHOW2`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAmusementParkShowAmusementPark" );
      ReorgSubmitThreadPool.addPrecedence( "RIAmusementParkShowAmusementPark" ,  "CreateAmusementParkShow" );
      GXReorganization.addMsg( 3 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAMUSEMENTPARKSHOW1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAmusementParkShowShow" );
      ReorgSubmitThreadPool.addPrecedence( "RIAmusementParkShowShow" ,  "CreateAmusementParkShow" );
   }

   private void executeReorganization( )
   {
      if ( ErrCode == 0 )
      {
         tablesCount( ) ;
         if ( ! GXReorganization.getRecordCount( ) )
         {
            FirstActions( ) ;
            setPrecedence( ) ;
            executeTablesReorganization( ) ;
         }
      }
   }

   public synchronized void DropTableConstraints( String sTableName ,
                                                  String sMySchemaName ) throws SQLException
   {
      String cmdBuffer;
      /* Using cursor P00023 */
      pr_default.execute(1, new Object[] {sTableName, sMySchemaName});
      while ( (pr_default.getStatus(1) != 101) )
      {
         tablename = P00023_Atablename[0] ;
         ntablename = P00023_ntablename[0] ;
         referencedtablename = P00023_Areferencedtablename[0] ;
         nreferencedtablename = P00023_nreferencedtablename[0] ;
         constid = P00023_Aconstid[0] ;
         nconstid = P00023_nconstid[0] ;
         schemaname = P00023_Aschemaname[0] ;
         nschemaname = P00023_nschemaname[0] ;
         cmdBuffer = "ALTER TABLE " + "" + tablename + "" + " DROP FOREIGN KEY " + "" + constid + "" ;
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void UtilsCleanup( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void submitReorg( int submitId ,
                            Object [] submitParms ) throws SQLException
   {
      UserInformation submitUI = Application.getConnectionManager().createUserInformation(Namespace.getNamespace(context.getNAME_SPACE()));
      switch ( submitId )
      {
            case 1 :
               GXReorganization.replaceMsg( 1 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AmusementParkShow",""})+" STARTED" );
               CreateAmusementParkShow( ) ;
               GXReorganization.replaceMsg( 1 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AmusementParkShow",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 2 :
               GXReorganization.replaceMsg( 2 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAMUSEMENTPARKSHOW2`"})+" STARTED" );
               RIAmusementParkShowAmusementPark( ) ;
               GXReorganization.replaceMsg( 2 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAMUSEMENTPARKSHOW2`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 3 :
               GXReorganization.replaceMsg( 3 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAMUSEMENTPARKSHOW1`"})+" STARTED" );
               RIAmusementParkShowShow( ) ;
               GXReorganization.replaceMsg( 3 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAMUSEMENTPARKSHOW1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
      }
   }

   public void initialize( )
   {
      sSchemaVar = "" ;
      sTableName = "" ;
      sMySchemaName = "" ;
      tablename = "" ;
      ntablename = false ;
      schemaname = "" ;
      nschemaname = false ;
      scmdbuf = "" ;
      P00012_Atablename = new String[] {""} ;
      P00012_ntablename = new boolean[] {false} ;
      P00012_Aschemaname = new String[] {""} ;
      P00012_nschemaname = new boolean[] {false} ;
      referencedtablename = "" ;
      nreferencedtablename = false ;
      constid = "" ;
      nconstid = false ;
      P00023_Atablename = new String[] {""} ;
      P00023_ntablename = new boolean[] {false} ;
      P00023_Areferencedtablename = new String[] {""} ;
      P00023_nreferencedtablename = new boolean[] {false} ;
      P00023_Aconstid = new String[] {""} ;
      P00023_nconstid = new boolean[] {false} ;
      P00023_Aschemaname = new String[] {""} ;
      P00023_nschemaname = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.reorg__default(),
         new Object[] {
             new Object[] {
            P00012_Atablename, P00012_Aschemaname
            }
            , new Object[] {
            P00023_Atablename, P00023_Areferencedtablename, P00023_Aconstid, P00023_Aschemaname
            }
         }
      );
      /* GeneXus formulas. */
   }

   protected short ErrCode ;
   protected String sSchemaVar ;
   protected String sTableName ;
   protected String sMySchemaName ;
   protected String scmdbuf ;
   protected boolean ntablename ;
   protected boolean nschemaname ;
   protected boolean nreferencedtablename ;
   protected boolean nconstid ;
   protected String tablename ;
   protected String schemaname ;
   protected String referencedtablename ;
   protected String constid ;
   protected IDataStoreProvider pr_default ;
   protected String[] P00012_Atablename ;
   protected boolean[] P00012_ntablename ;
   protected String[] P00012_Aschemaname ;
   protected boolean[] P00012_nschemaname ;
   protected String[] P00023_Atablename ;
   protected boolean[] P00023_ntablename ;
   protected String[] P00023_Areferencedtablename ;
   protected boolean[] P00023_nreferencedtablename ;
   protected String[] P00023_Aconstid ;
   protected boolean[] P00023_nconstid ;
   protected String[] P00023_Aschemaname ;
   protected boolean[] P00023_nschemaname ;
}

final  class reorg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00012", "SELECT table_name, table_schema FROM INFORMATION_SCHEMA.TABLES WHERE (table_name = ?) AND (table_schema = ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00023", "SELECT DISTINCT TABLE_NAME, REFERENCED_TABLE_NAME, CONSTRAINT_NAME, TABLE_SCHEMA FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE (REFERENCED_TABLE_NAME = ?) AND (TABLE_SCHEMA = ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 255);
               stmt.setString(2, (String)parms[1], 255);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 255);
               stmt.setString(2, (String)parms[1], 255);
               return;
      }
   }

}


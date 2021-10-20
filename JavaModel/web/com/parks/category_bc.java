package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class category_bc extends GXWebPanel implements IGxSilentTrn
{
   public category_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public category_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( category_bc.class ));
   }

   public category_bc( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow066( ) ;
      standaloneNotModal( ) ;
      initializeNonKey066( ) ;
      standaloneModal( ) ;
      addRow066( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e11062 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z19CategoryId = A19CategoryId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_060( )
   {
      beforeValidate066( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls066( ) ;
         }
         else
         {
            checkExtendedTable066( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors066( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12062( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e11062( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm066( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         Z20CategoryName = A20CategoryName ;
      }
      if ( GX_JID == -1 )
      {
         Z19CategoryId = A19CategoryId ;
         Z20CategoryName = A20CategoryName ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load066( )
   {
      /* Using cursor BC00064 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound6 = (short)(1) ;
         A20CategoryName = BC00064_A20CategoryName[0] ;
         zm066( -1) ;
      }
      pr_default.close(2);
      onLoadActions066( ) ;
   }

   public void onLoadActions066( )
   {
   }

   public void checkExtendedTable066( )
   {
      nIsDirty_6 = (short)(0) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors066( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey066( )
   {
      /* Using cursor BC00065 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound6 = (short)(1) ;
      }
      else
      {
         RcdFound6 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00066 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm066( 1) ;
         RcdFound6 = (short)(1) ;
         A19CategoryId = BC00066_A19CategoryId[0] ;
         n19CategoryId = BC00066_n19CategoryId[0] ;
         A20CategoryName = BC00066_A20CategoryName[0] ;
         Z19CategoryId = A19CategoryId ;
         sMode6 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load066( ) ;
         if ( AnyError == 1 )
         {
            RcdFound6 = (short)(0) ;
            initializeNonKey066( ) ;
         }
         Gx_mode = sMode6 ;
      }
      else
      {
         RcdFound6 = (short)(0) ;
         initializeNonKey066( ) ;
         sMode6 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode6 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey066( ) ;
      if ( RcdFound6 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_060( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency066( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00067 */
         pr_default.execute(5, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Category"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z20CategoryName, BC00067_A20CategoryName[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Category"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert066( )
   {
      beforeValidate066( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable066( ) ;
      }
      if ( AnyError == 0 )
      {
         zm066( 0) ;
         checkOptimisticConcurrency066( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm066( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert066( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00068 */
                  pr_default.execute(6, new Object[] {A20CategoryName});
                  /* Retrieving last key number assigned */
                  /* Using cursor BC00069 */
                  pr_default.execute(7);
                  A19CategoryId = BC00069_A19CategoryId[0] ;
                  n19CategoryId = BC00069_n19CategoryId[0] ;
                  pr_default.close(7);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Category");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load066( ) ;
         }
         endLevel066( ) ;
      }
      closeExtendedTableCursors066( ) ;
   }

   public void update066( )
   {
      beforeValidate066( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable066( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency066( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm066( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate066( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000610 */
                  pr_default.execute(8, new Object[] {A20CategoryName, Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Category");
                  if ( (pr_default.getStatus(8) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Category"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate066( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel066( ) ;
      }
      closeExtendedTableCursors066( ) ;
   }

   public void deferredUpdate066( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate066( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency066( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls066( ) ;
         afterConfirm066( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete066( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000611 */
               pr_default.execute(9, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Category");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode6 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel066( ) ;
      Gx_mode = sMode6 ;
   }

   public void onDeleteControls066( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor BC000612 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Game"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
      }
   }

   public void endLevel066( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete066( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart066( )
   {
      /* Scan By routine */
      /* Using cursor BC000613 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
      RcdFound6 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound6 = (short)(1) ;
         A19CategoryId = BC000613_A19CategoryId[0] ;
         n19CategoryId = BC000613_n19CategoryId[0] ;
         A20CategoryName = BC000613_A20CategoryName[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext066( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound6 = (short)(0) ;
      scanKeyLoad066( ) ;
   }

   public void scanKeyLoad066( )
   {
      sMode6 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound6 = (short)(1) ;
         A19CategoryId = BC000613_A19CategoryId[0] ;
         n19CategoryId = BC000613_n19CategoryId[0] ;
         A20CategoryName = BC000613_A20CategoryName[0] ;
      }
      Gx_mode = sMode6 ;
   }

   public void scanKeyEnd066( )
   {
      pr_default.close(11);
   }

   public void afterConfirm066( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert066( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate066( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete066( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete066( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate066( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes066( )
   {
   }

   public void send_integrity_lvl_hashes066( )
   {
   }

   public void addRow066( )
   {
      VarsToRow6( bcCategory) ;
   }

   public void readRow066( )
   {
      RowToVars6( bcCategory, 1) ;
   }

   public void initializeNonKey066( )
   {
      A20CategoryName = "" ;
      Z20CategoryName = "" ;
   }

   public void initAll066( )
   {
      A19CategoryId = (short)(0) ;
      n19CategoryId = false ;
      initializeNonKey066( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow6( com.parks.SdtCategory obj6 )
   {
      obj6.setgxTv_SdtCategory_Mode( Gx_mode );
      obj6.setgxTv_SdtCategory_Categoryname( A20CategoryName );
      obj6.setgxTv_SdtCategory_Categoryid( A19CategoryId );
      obj6.setgxTv_SdtCategory_Categoryid_Z( Z19CategoryId );
      obj6.setgxTv_SdtCategory_Categoryname_Z( Z20CategoryName );
      obj6.setgxTv_SdtCategory_Categoryid_N( (byte)((byte)((n19CategoryId)?1:0)) );
      obj6.setgxTv_SdtCategory_Mode( Gx_mode );
   }

   public void KeyVarsToRow6( com.parks.SdtCategory obj6 )
   {
      obj6.setgxTv_SdtCategory_Categoryid( A19CategoryId );
   }

   public void RowToVars6( com.parks.SdtCategory obj6 ,
                           int forceLoad )
   {
      Gx_mode = obj6.getgxTv_SdtCategory_Mode() ;
      A20CategoryName = obj6.getgxTv_SdtCategory_Categoryname() ;
      A19CategoryId = obj6.getgxTv_SdtCategory_Categoryid() ;
      n19CategoryId = false ;
      Z19CategoryId = obj6.getgxTv_SdtCategory_Categoryid_Z() ;
      Z20CategoryName = obj6.getgxTv_SdtCategory_Categoryname_Z() ;
      n19CategoryId = (boolean)((obj6.getgxTv_SdtCategory_Categoryid_N()==0)?false:true) ;
      Gx_mode = obj6.getgxTv_SdtCategory_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A19CategoryId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      n19CategoryId = false ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey066( ) ;
      scanKeyStart066( ) ;
      if ( RcdFound6 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z19CategoryId = A19CategoryId ;
      }
      zm066( -1) ;
      onLoadActions066( ) ;
      addRow066( ) ;
      scanKeyEnd066( ) ;
      if ( RcdFound6 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars6( bcCategory, 0) ;
      scanKeyStart066( ) ;
      if ( RcdFound6 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z19CategoryId = A19CategoryId ;
      }
      zm066( -1) ;
      onLoadActions066( ) ;
      addRow066( ) ;
      scanKeyEnd066( ) ;
      if ( RcdFound6 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey066( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert066( ) ;
      }
      else
      {
         if ( RcdFound6 == 1 )
         {
            if ( A19CategoryId != Z19CategoryId )
            {
               A19CategoryId = Z19CategoryId ;
               n19CategoryId = false ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update066( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A19CategoryId != Z19CategoryId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert066( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert066( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars6( bcCategory, 1) ;
      saveImpl( ) ;
      VarsToRow6( bcCategory) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars6( bcCategory, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert066( ) ;
      afterTrn( ) ;
      VarsToRow6( bcCategory) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         com.parks.SdtCategory auxBC = new com.parks.SdtCategory( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A19CategoryId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcCategory);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars6( bcCategory, 1) ;
      updateImpl( ) ;
      VarsToRow6( bcCategory) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars6( bcCategory, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert066( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow6( bcCategory) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars6( bcCategory, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey066( ) ;
      if ( RcdFound6 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A19CategoryId != Z19CategoryId )
         {
            A19CategoryId = Z19CategoryId ;
            n19CategoryId = false ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A19CategoryId != Z19CategoryId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "category_bc");
      VarsToRow6( bcCategory) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcCategory.getgxTv_SdtCategory_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcCategory.setgxTv_SdtCategory_Mode( Gx_mode );
   }

   public void SetSDT( com.parks.SdtCategory sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcCategory )
      {
         bcCategory = sdt ;
         if ( GXutil.strcmp(bcCategory.getgxTv_SdtCategory_Mode(), "") == 0 )
         {
            bcCategory.setgxTv_SdtCategory_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow6( bcCategory) ;
         }
         else
         {
            RowToVars6( bcCategory, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcCategory.getgxTv_SdtCategory_Mode(), "") == 0 )
         {
            bcCategory.setgxTv_SdtCategory_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars6( bcCategory, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtCategory getCategory_BC( )
   {
      return bcCategory ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z20CategoryName = "" ;
      A20CategoryName = "" ;
      BC00064_A19CategoryId = new short[1] ;
      BC00064_n19CategoryId = new boolean[] {false} ;
      BC00064_A20CategoryName = new String[] {""} ;
      BC00065_A19CategoryId = new short[1] ;
      BC00065_n19CategoryId = new boolean[] {false} ;
      BC00066_A19CategoryId = new short[1] ;
      BC00066_n19CategoryId = new boolean[] {false} ;
      BC00066_A20CategoryName = new String[] {""} ;
      sMode6 = "" ;
      BC00067_A19CategoryId = new short[1] ;
      BC00067_n19CategoryId = new boolean[] {false} ;
      BC00067_A20CategoryName = new String[] {""} ;
      BC00069_A19CategoryId = new short[1] ;
      BC00069_n19CategoryId = new boolean[] {false} ;
      BC000612_A17GameId = new short[1] ;
      BC000613_A19CategoryId = new short[1] ;
      BC000613_n19CategoryId = new boolean[] {false} ;
      BC000613_A20CategoryName = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.category_bc__default(),
         new Object[] {
             new Object[] {
            BC00062_A19CategoryId, BC00062_A20CategoryName
            }
            , new Object[] {
            BC00063_A19CategoryId, BC00063_A20CategoryName
            }
            , new Object[] {
            BC00064_A19CategoryId, BC00064_A20CategoryName
            }
            , new Object[] {
            BC00065_A19CategoryId
            }
            , new Object[] {
            BC00066_A19CategoryId, BC00066_A20CategoryName
            }
            , new Object[] {
            BC00067_A19CategoryId, BC00067_A20CategoryName
            }
            , new Object[] {
            }
            , new Object[] {
            BC00069_A19CategoryId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000612_A17GameId
            }
            , new Object[] {
            BC000613_A19CategoryId, BC000613_A20CategoryName
            }
         }
      );
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12062 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z19CategoryId ;
   private short A19CategoryId ;
   private short RcdFound6 ;
   private short nIsDirty_6 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z20CategoryName ;
   private String A20CategoryName ;
   private String sMode6 ;
   private boolean returnInSub ;
   private boolean n19CategoryId ;
   private boolean mustCommit ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.parks.SdtCategory bcCategory ;
   private IDataStoreProvider pr_default ;
   private short[] BC00064_A19CategoryId ;
   private boolean[] BC00064_n19CategoryId ;
   private String[] BC00064_A20CategoryName ;
   private short[] BC00065_A19CategoryId ;
   private boolean[] BC00065_n19CategoryId ;
   private short[] BC00066_A19CategoryId ;
   private boolean[] BC00066_n19CategoryId ;
   private String[] BC00066_A20CategoryName ;
   private short[] BC00067_A19CategoryId ;
   private boolean[] BC00067_n19CategoryId ;
   private String[] BC00067_A20CategoryName ;
   private short[] BC00069_A19CategoryId ;
   private boolean[] BC00069_n19CategoryId ;
   private short[] BC000612_A17GameId ;
   private short[] BC000613_A19CategoryId ;
   private boolean[] BC000613_n19CategoryId ;
   private String[] BC000613_A20CategoryName ;
   private short[] BC00062_A19CategoryId ;
   private String[] BC00062_A20CategoryName ;
   private short[] BC00063_A19CategoryId ;
   private String[] BC00063_A20CategoryName ;
}

final  class category_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00062", "SELECT `CategoryId`, `CategoryName` FROM `Category` WHERE `CategoryId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00063", "SELECT `CategoryId`, `CategoryName` FROM `Category` WHERE `CategoryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00064", "SELECT TM1.`CategoryId`, TM1.`CategoryName` FROM `Category` TM1 WHERE TM1.`CategoryId` = ? ORDER BY TM1.`CategoryId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00065", "SELECT `CategoryId` FROM `Category` WHERE `CategoryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00066", "SELECT `CategoryId`, `CategoryName` FROM `Category` WHERE `CategoryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00067", "SELECT `CategoryId`, `CategoryName` FROM `Category` WHERE `CategoryId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC00068", "INSERT INTO `Category`(`CategoryName`) VALUES(?)", GX_NOMASK)
         ,new ForEachCursor("BC00069", "SELECT LAST_INSERT_ID() ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000610", "UPDATE `Category` SET `CategoryName`=?  WHERE `CategoryId` = ?", GX_NOMASK)
         ,new UpdateCursor("BC000611", "DELETE FROM `Category`  WHERE `CategoryId` = ?", GX_NOMASK)
         ,new ForEachCursor("BC000612", "SELECT `GameId` FROM `Game` WHERE `CategoryId` = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000613", "SELECT TM1.`CategoryId`, TM1.`CategoryName` FROM `Category` TM1 WHERE TM1.`CategoryId` = ? ORDER BY TM1.`CategoryId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 50);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 50);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}


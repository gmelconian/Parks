gx.evt.autoSkip=!1;gx.define("showgeneral",!0,function(n){this.ServerClass="showgeneral";this.PackageName="com.parks";this.ServerFullClass="com.parks.showgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.SetStandaloneVars=function(){};this.Valid_Showid=function(){return this.validCliEvt("Valid_Showid",0,function(){try{var n=gx.util.balloon.getNew("SHOWID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11121_client=function(){return this.clearMessages(),this.call("com.parks.show",["UPD",this.A14ShowId],null,["Mode","ShowId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12121_client=function(){return this.clearMessages(),this.call("com.parks.show",["DLT",this.A14ShowId],null,["Mode","ShowId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e15122_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e16122_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39];this.GXLastCtrlId=39;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"MAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"BTNUPDATE",grid:0,evt:"e11121_client"};t[9]={id:9,fld:"",grid:0};t[10]={id:10,fld:"BTNDELETE",grid:0,evt:"e12121_client"};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"ATTRIBUTESTABLE",grid:0};t[14]={id:14,fld:"",grid:0};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Showid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SHOWID",gxz:"Z14ShowId",gxold:"O14ShowId",gxvar:"A14ShowId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A14ShowId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z14ShowId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("SHOWID",gx.O.A14ShowId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A14ShowId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SHOWID",".")},nac:gx.falseFn};this.declareDomainHdlr(18,function(){});t[19]={id:19,fld:"",grid:0};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,lvl:0,type:"char",len:50,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SHOWNAME",gxz:"Z15ShowName",gxold:"O15ShowName",gxvar:"A15ShowName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A15ShowName=n)},v2z:function(n){n!==undefined&&(gx.O.Z15ShowName=n)},v2c:function(){gx.fn.setControlValue("SHOWNAME",gx.O.A15ShowName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A15ShowName=this.val())},val:function(){return gx.fn.getControlValue("SHOWNAME")},nac:gx.falseFn};this.declareDomainHdlr(23,function(){});t[24]={id:24,fld:"",grid:0};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SHOWDATE",gxz:"Z50ShowDate",gxold:"O50ShowDate",gxvar:"A50ShowDate",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A50ShowDate=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z50ShowDate=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("SHOWDATE",gx.O.A50ShowDate,0)},c2v:function(){this.val()!==undefined&&(gx.O.A50ShowDate=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("SHOWDATE")},nac:gx.falseFn};t[29]={id:29,fld:"",grid:0};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,lvl:0,type:"dtime",len:8,dec:5,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SHOWSCHEDULE",gxz:"Z51ShowSchedule",gxold:"O51ShowSchedule",gxvar:"A51ShowSchedule",dp:{f:0,st:!0,wn:!1,mf:!1,pic:"99/99/99 99:99",dec:5},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A51ShowSchedule=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z51ShowSchedule=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("SHOWSCHEDULE",gx.O.A51ShowSchedule,0)},c2v:function(){this.val()!==undefined&&(gx.O.A51ShowSchedule=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getDateTimeValue("SHOWSCHEDULE")},nac:gx.falseFn};t[34]={id:34,fld:"",grid:0};t[35]={id:35,fld:"IMAGESTABLE",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,lvl:0,type:"bits",len:1024,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SHOWIMAGE",gxz:"Z16ShowImage",gxold:"O16ShowImage",gxvar:"A16ShowImage",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A16ShowImage=n)},v2z:function(n){n!==undefined&&(gx.O.Z16ShowImage=n)},v2c:function(){gx.fn.setMultimediaValue("SHOWIMAGE",gx.O.A16ShowImage,gx.O.A40000ShowImage_GXI)},c2v:function(){gx.O.A40000ShowImage_GXI=this.val_GXI();this.val()!==undefined&&(gx.O.A16ShowImage=this.val())},val:function(){return gx.fn.getBlobValue("SHOWIMAGE")},val_GXI:function(){return gx.fn.getControlValue("SHOWIMAGE_GXI")},gxvar_GXI:"A40000ShowImage_GXI",nac:gx.falseFn};this.A14ShowId=0;this.Z14ShowId=0;this.O14ShowId=0;this.A15ShowName="";this.Z15ShowName="";this.O15ShowName="";this.A50ShowDate=gx.date.nullDate();this.Z50ShowDate=gx.date.nullDate();this.O50ShowDate=gx.date.nullDate();this.A51ShowSchedule=gx.date.nullDate();this.Z51ShowSchedule=gx.date.nullDate();this.O51ShowSchedule=gx.date.nullDate();this.A40000ShowImage_GXI="";this.A16ShowImage="";this.Z16ShowImage="";this.O16ShowImage="";this.A14ShowId=0;this.A15ShowName="";this.A50ShowDate=gx.date.nullDate();this.A51ShowSchedule=gx.date.nullDate();this.A16ShowImage="";this.A40000ShowImage_GXI="";this.Events={e15122_client:["ENTER",!0],e16122_client:["CANCEL",!0],e11121_client:["'DOUPDATE'",!1],e12121_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A14ShowId",fld:"SHOWID",pic:"ZZZ9"}],[]];this.EvtParms.START=[[{av:"AV13Pgmname",fld:"vPGMNAME",pic:""},{av:"AV6ShowId",fld:"vSHOWID",pic:"ZZZ9"}],[]];this.EvtParms.LOAD=[[],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A14ShowId",fld:"SHOWID",pic:"ZZZ9"}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A14ShowId",fld:"SHOWID",pic:"ZZZ9"}],[]];this.EvtParms.VALID_SHOWID=[[],[]];this.Initialize()})
gx.evt.autoSkip=!1;gx.define("wwtechnician",!1,function(){var n,t;this.ServerClass="wwtechnician";this.PackageName="com.parks";this.ServerFullClass="com.parks.wwtechnician";this.setObjectType("web");this.anyGridBaseTable=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.SetStandaloneVars=function(){this.A12CountryId=gx.fn.getIntegerValue("COUNTRYID",".")};this.e111a2_client=function(){return this.executeServerEvent("'DOINSERT'",!1,null,!1,!1)};this.e151a2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e161a2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,23,24,26,27,28,29,30,31,32,33];this.GXLastCtrlId=33;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",25,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"wwtechnician",[],!1,1,!1,!0,0,!0,!1,!1,"",0,"px",0,"px","Nueva fila",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.GridContainer;t.addSingleLineEdit(30,26,"TECHNICIANID","Id","","TechnicianId","int",0,"px",4,4,"right",null,[],30,"TechnicianId",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");t.addSingleLineEdit(31,27,"TECHNICIANNAME","Name","","TechnicianName","char",0,"px",50,50,"left",null,[],31,"TechnicianName",!0,0,!1,!1,"DescriptionAttribute",1,"WWColumn");t.addSingleLineEdit(32,28,"TECHNICIANLASTNAME","Last Name","","TechnicianLastName","char",0,"px",20,20,"left",null,[],32,"TechnicianLastName",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");t.addSingleLineEdit(33,29,"TECHNICIANPHONE","Phone","","TechnicianPhone","char",0,"px",20,20,"left",null,[],33,"TechnicianPhone",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");t.addSingleLineEdit(13,30,"COUNTRYNAME","Country Name","","CountryName","char",0,"px",50,50,"left",null,[],13,"CountryName",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");t.addSingleLineEdit(25,31,"CITYNAME","City Name","","CityName","char",0,"px",50,50,"left",null,[],25,"CityName",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");t.addSingleLineEdit("Update",32,"vUPDATE","","","Update","char",0,"px",20,20,"left",null,[],"Update","Update",!0,0,!1,!1,"TextActionAttribute",1,"WWTextActionColumn");t.addSingleLineEdit("Delete",33,"vDELETE","","","Delete","char",0,"px",20,20,"left",null,[],"Delete","Delete",!0,0,!1,!1,"TextActionAttribute",1,"WWTextActionColumn");this.GridContainer.emptyText="";this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLETOP",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TITLETEXT",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"",grid:0};n[13]={id:13,fld:"BTNINSERT",grid:0,evt:"e111a2_client"};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"",grid:0};n[16]={id:16,lvl:0,type:"char",len:50,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.GridContainer],fld:"vTECHNICIANNAME",gxz:"ZV11TechnicianName",gxold:"OV11TechnicianName",gxvar:"AV11TechnicianName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV11TechnicianName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV11TechnicianName=n)},v2c:function(){gx.fn.setControlValue("vTECHNICIANNAME",gx.O.AV11TechnicianName,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV11TechnicianName=this.val())},val:function(){return gx.fn.getControlValue("vTECHNICIANNAME")},nac:gx.falseFn};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"GRIDCELL",grid:0};n[19]={id:19,fld:"GRIDTABLE",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[26]={id:26,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:25,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANID",gxz:"Z30TechnicianId",gxold:"O30TechnicianId",gxvar:"A30TechnicianId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A30TechnicianId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z30TechnicianId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANID",n||gx.fn.currentGridRowImpl(25),gx.O.A30TechnicianId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A30TechnicianId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("TECHNICIANID",n||gx.fn.currentGridRowImpl(25),".")},nac:gx.falseFn};n[27]={id:27,lvl:2,type:"char",len:50,dec:0,sign:!1,ro:1,isacc:0,grid:25,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANNAME",gxz:"Z31TechnicianName",gxold:"O31TechnicianName",gxvar:"A31TechnicianName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A31TechnicianName=n)},v2z:function(n){n!==undefined&&(gx.O.Z31TechnicianName=n)},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANNAME",n||gx.fn.currentGridRowImpl(25),gx.O.A31TechnicianName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A31TechnicianName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("TECHNICIANNAME",n||gx.fn.currentGridRowImpl(25))},nac:gx.falseFn};n[28]={id:28,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:25,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANLASTNAME",gxz:"Z32TechnicianLastName",gxold:"O32TechnicianLastName",gxvar:"A32TechnicianLastName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A32TechnicianLastName=n)},v2z:function(n){n!==undefined&&(gx.O.Z32TechnicianLastName=n)},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANLASTNAME",n||gx.fn.currentGridRowImpl(25),gx.O.A32TechnicianLastName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A32TechnicianLastName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("TECHNICIANLASTNAME",n||gx.fn.currentGridRowImpl(25))},nac:gx.falseFn};n[29]={id:29,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:25,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANPHONE",gxz:"Z33TechnicianPhone",gxold:"O33TechnicianPhone",gxvar:"A33TechnicianPhone",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"tel",v2v:function(n){n!==undefined&&(gx.O.A33TechnicianPhone=n)},v2z:function(n){n!==undefined&&(gx.O.Z33TechnicianPhone=n)},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANPHONE",n||gx.fn.currentGridRowImpl(25),gx.O.A33TechnicianPhone,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A33TechnicianPhone=this.val(n))},val:function(n){return gx.fn.getGridControlValue("TECHNICIANPHONE",n||gx.fn.currentGridRowImpl(25))},nac:gx.falseFn};n[30]={id:30,lvl:2,type:"char",len:50,dec:0,sign:!1,ro:1,isacc:0,grid:25,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COUNTRYNAME",gxz:"Z13CountryName",gxold:"O13CountryName",gxvar:"A13CountryName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A13CountryName=n)},v2z:function(n){n!==undefined&&(gx.O.Z13CountryName=n)},v2c:function(n){gx.fn.setGridControlValue("COUNTRYNAME",n||gx.fn.currentGridRowImpl(25),gx.O.A13CountryName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A13CountryName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("COUNTRYNAME",n||gx.fn.currentGridRowImpl(25))},nac:gx.falseFn};n[31]={id:31,lvl:2,type:"char",len:50,dec:0,sign:!1,ro:1,isacc:0,grid:25,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CITYNAME",gxz:"Z25CityName",gxold:"O25CityName",gxvar:"A25CityName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A25CityName=n)},v2z:function(n){n!==undefined&&(gx.O.Z25CityName=n)},v2c:function(n){gx.fn.setGridControlValue("CITYNAME",n||gx.fn.currentGridRowImpl(25),gx.O.A25CityName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A25CityName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("CITYNAME",n||gx.fn.currentGridRowImpl(25))},nac:gx.falseFn};n[32]={id:32,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:25,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vUPDATE",gxz:"ZV12Update",gxold:"OV12Update",gxvar:"AV12Update",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV12Update=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12Update=n)},v2c:function(n){gx.fn.setGridControlValue("vUPDATE",n||gx.fn.currentGridRowImpl(25),gx.O.AV12Update,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV12Update=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vUPDATE",n||gx.fn.currentGridRowImpl(25))},nac:gx.falseFn};n[33]={id:33,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:25,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDELETE",gxz:"ZV13Delete",gxold:"OV13Delete",gxvar:"AV13Delete",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV13Delete=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13Delete=n)},v2c:function(n){gx.fn.setGridControlValue("vDELETE",n||gx.fn.currentGridRowImpl(25),gx.O.AV13Delete,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV13Delete=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDELETE",n||gx.fn.currentGridRowImpl(25))},nac:gx.falseFn};this.AV11TechnicianName="";this.ZV11TechnicianName="";this.OV11TechnicianName="";this.Z30TechnicianId=0;this.O30TechnicianId=0;this.Z31TechnicianName="";this.O31TechnicianName="";this.Z32TechnicianLastName="";this.O32TechnicianLastName="";this.Z33TechnicianPhone="";this.O33TechnicianPhone="";this.Z13CountryName="";this.O13CountryName="";this.Z25CityName="";this.O25CityName="";this.ZV12Update="";this.OV12Update="";this.ZV13Delete="";this.OV13Delete="";this.AV11TechnicianName="";this.A12CountryId=0;this.A24CityId=0;this.A30TechnicianId=0;this.A31TechnicianName="";this.A32TechnicianLastName="";this.A33TechnicianPhone="";this.A13CountryName="";this.A25CityName="";this.AV12Update="";this.AV13Delete="";this.Events={e111a2_client:["'DOINSERT'",!0],e151a2_client:["ENTER",!0],e161a2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV11TechnicianName",fld:"vTECHNICIANNAME",pic:""},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""}],[]];this.EvtParms.START=[[{av:"AV17Pgmname",fld:"vPGMNAME",pic:""}],[{ctrl:"GRID",prop:"Rows"},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""},{ctrl:"FORM",prop:"Caption"}]];this.EvtParms["GRID.LOAD"]=[[{av:"A30TechnicianId",fld:"TECHNICIANID",pic:"ZZZ9",hsh:!0},{av:"A12CountryId",fld:"COUNTRYID",pic:"ZZZ9"}],[{av:'gx.fn.getCtrlProperty("vUPDATE","Link")',ctrl:"vUPDATE",prop:"Link"},{av:'gx.fn.getCtrlProperty("vDELETE","Link")',ctrl:"vDELETE",prop:"Link"},{av:'gx.fn.getCtrlProperty("TECHNICIANNAME","Link")',ctrl:"TECHNICIANNAME",prop:"Link"},{av:'gx.fn.getCtrlProperty("COUNTRYNAME","Link")',ctrl:"COUNTRYNAME",prop:"Link"}]];this.EvtParms["'DOINSERT'"]=[[{av:"A30TechnicianId",fld:"TECHNICIANID",pic:"ZZZ9",hsh:!0}],[]];this.EvtParms.GRID_FIRSTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV11TechnicianName",fld:"vTECHNICIANNAME",pic:""},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""}],[]];this.EvtParms.GRID_PREVPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV11TechnicianName",fld:"vTECHNICIANNAME",pic:""},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""}],[]];this.EvtParms.GRID_NEXTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV11TechnicianName",fld:"vTECHNICIANNAME",pic:""},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""}],[]];this.EvtParms.GRID_LASTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV11TechnicianName",fld:"vTECHNICIANNAME",pic:""},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""}],[]];this.setVCMap("A12CountryId","COUNTRYID",0,"int",4,0);t.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});t.addRefreshingVar(this.GXValidFnc[16]);t.addRefreshingVar({rfrVar:"AV12Update",rfrProp:"Value",gxAttId:"Update"});t.addRefreshingVar({rfrVar:"AV13Delete",rfrProp:"Value",gxAttId:"Delete"});t.addRefreshingParm(this.GXValidFnc[16]);t.addRefreshingParm({rfrVar:"AV12Update",rfrProp:"Value",gxAttId:"Update"});t.addRefreshingParm({rfrVar:"AV13Delete",rfrProp:"Value",gxAttId:"Delete"});this.Initialize()});gx.wi(function(){gx.createParentObj(this.wwtechnician)})
gx.evt.autoSkip=!1;gx.define("gx0090",!1,function(){var n,t;this.ServerClass="gx0090";this.PackageName="com.parks";this.ServerFullClass="com.parks.gx0090";this.setObjectType("web");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.SetStandaloneVars=function(){this.AV12pTechnicianId=gx.fn.getIntegerValue("vPTECHNICIANID",".")};this.e17141_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class"),"AdvancedContainer")==0?(gx.fn.setCtrlProperty("ADVANCEDCONTAINER","Class","AdvancedContainer AdvancedContainerVisible"),gx.fn.setCtrlProperty("BTNTOGGLE","Class",gx.fn.getCtrlProperty("BTNTOGGLE","Class")+" BtnToggleActive")):(gx.fn.setCtrlProperty("ADVANCEDCONTAINER","Class","AdvancedContainer"),gx.fn.setCtrlProperty("BTNTOGGLE","Class","BtnToggle")),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e11141_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCTECHNICIANID","Visible",!0)):(gx.fn.setCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCTECHNICIANID","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class")',ctrl:"TECHNICIANIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANID","Visible")',ctrl:"vCTECHNICIANID",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12141_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TECHNICIANNAMEFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("TECHNICIANNAMEFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCTECHNICIANNAME","Visible",!0)):(gx.fn.setCtrlProperty("TECHNICIANNAMEFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCTECHNICIANNAME","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TECHNICIANNAMEFILTERCONTAINER","Class")',ctrl:"TECHNICIANNAMEFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANNAME","Visible")',ctrl:"vCTECHNICIANNAME",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e13141_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TECHNICIANLASTNAMEFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("TECHNICIANLASTNAMEFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCTECHNICIANLASTNAME","Visible",!0)):(gx.fn.setCtrlProperty("TECHNICIANLASTNAMEFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCTECHNICIANLASTNAME","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TECHNICIANLASTNAMEFILTERCONTAINER","Class")',ctrl:"TECHNICIANLASTNAMEFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANLASTNAME","Visible")',ctrl:"vCTECHNICIANLASTNAME",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14141_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("TECHNICIANPHONEFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("TECHNICIANPHONEFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCTECHNICIANPHONE","Visible",!0)):(gx.fn.setCtrlProperty("TECHNICIANPHONEFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCTECHNICIANPHONE","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TECHNICIANPHONEFILTERCONTAINER","Class")',ctrl:"TECHNICIANPHONEFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANPHONE","Visible")',ctrl:"vCTECHNICIANPHONE",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e15141_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("COUNTRYIDFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("COUNTRYIDFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCCOUNTRYID","Visible",!0)):(gx.fn.setCtrlProperty("COUNTRYIDFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCCOUNTRYID","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("COUNTRYIDFILTERCONTAINER","Class")',ctrl:"COUNTRYIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCCOUNTRYID","Visible")',ctrl:"vCCOUNTRYID",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16141_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("CITYIDFILTERCONTAINER","Class"),"AdvancedContainerItem")==0?(gx.fn.setCtrlProperty("CITYIDFILTERCONTAINER","Class","AdvancedContainerItem AdvancedContainerItemExpanded"),gx.fn.setCtrlProperty("vCCITYID","Visible",!0)):(gx.fn.setCtrlProperty("CITYIDFILTERCONTAINER","Class","AdvancedContainerItem"),gx.fn.setCtrlProperty("vCCITYID","Visible",!1)),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("CITYIDFILTERCONTAINER","Class")',ctrl:"CITYIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCCITYID","Visible")',ctrl:"vCCITYID",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e20142_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e21141_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,75,76,77,78,79,80,81,82,83,84];this.GXLastCtrlId=84;this.Grid1Container=new gx.grid.grid(this,2,"WbpLvl2",74,"Grid1","Grid1","Grid1Container",this.CmpContext,this.IsMasterPage,"gx0090",[],!1,1,!1,!0,10,!0,!1,!1,"",0,"px",0,"px","Nueva fila",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.Grid1Container;t.addBitmap("&Linkselection","vLINKSELECTION",75,0,"px",17,"px",null,"","","SelectionAttribute","WWActionColumn");t.addSingleLineEdit(30,76,"TECHNICIANID","Id","","TechnicianId","int",0,"px",4,4,"right",null,[],30,"TechnicianId",!0,0,!1,!1,"Attribute",1,"WWColumn");t.addSingleLineEdit(31,77,"TECHNICIANNAME","Name","","TechnicianName","char",0,"px",50,50,"left",null,[],31,"TechnicianName",!0,0,!1,!1,"DescriptionAttribute",1,"WWColumn");t.addSingleLineEdit(32,78,"TECHNICIANLASTNAME","Last Name","","TechnicianLastName","char",0,"px",20,20,"left",null,[],32,"TechnicianLastName",!0,0,!1,!1,"Attribute",1,"WWColumn OptionalColumn");t.addSingleLineEdit(33,79,"TECHNICIANPHONE","Phone","","TechnicianPhone","char",0,"px",20,20,"left",null,[],33,"TechnicianPhone",!0,0,!1,!1,"Attribute",1,"WWColumn OptionalColumn");t.addSingleLineEdit(12,80,"COUNTRYID","Country Id","","CountryId","int",0,"px",4,4,"right",null,[],12,"CountryId",!0,0,!1,!1,"Attribute",1,"WWColumn OptionalColumn");t.addSingleLineEdit(24,81,"CITYID","City Id","","CityId","int",0,"px",4,4,"right",null,[],24,"CityId",!0,0,!1,!1,"Attribute",1,"WWColumn OptionalColumn");this.Grid1Container.emptyText="";this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAIN",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"ADVANCEDCONTAINER",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TECHNICIANIDFILTERCONTAINER",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"LBLTECHNICIANIDFILTER",format:1,grid:0,evt:"e11141_client",ctrltype:"textblock"};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"",grid:0};n[16]={id:16,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTECHNICIANID",gxz:"ZV6cTechnicianId",gxold:"OV6cTechnicianId",gxvar:"AV6cTechnicianId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV6cTechnicianId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV6cTechnicianId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCTECHNICIANID",gx.O.AV6cTechnicianId,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV6cTechnicianId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCTECHNICIANID",".")},nac:gx.falseFn};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"TECHNICIANNAMEFILTERCONTAINER",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"LBLTECHNICIANNAMEFILTER",format:1,grid:0,evt:"e12141_client",ctrltype:"textblock"};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,lvl:0,type:"char",len:50,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTECHNICIANNAME",gxz:"ZV7cTechnicianName",gxold:"OV7cTechnicianName",gxvar:"AV7cTechnicianName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV7cTechnicianName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV7cTechnicianName=n)},v2c:function(){gx.fn.setControlValue("vCTECHNICIANNAME",gx.O.AV7cTechnicianName,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV7cTechnicianName=this.val())},val:function(){return gx.fn.getControlValue("vCTECHNICIANNAME")},nac:gx.falseFn};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"TECHNICIANLASTNAMEFILTERCONTAINER",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"LBLTECHNICIANLASTNAMEFILTER",format:1,grid:0,evt:"e13141_client",ctrltype:"textblock"};n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTECHNICIANLASTNAME",gxz:"ZV8cTechnicianLastName",gxold:"OV8cTechnicianLastName",gxvar:"AV8cTechnicianLastName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV8cTechnicianLastName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV8cTechnicianLastName=n)},v2c:function(){gx.fn.setControlValue("vCTECHNICIANLASTNAME",gx.O.AV8cTechnicianLastName,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV8cTechnicianLastName=this.val())},val:function(){return gx.fn.getControlValue("vCTECHNICIANLASTNAME")},nac:gx.falseFn};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"TECHNICIANPHONEFILTERCONTAINER",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"LBLTECHNICIANPHONEFILTER",format:1,grid:0,evt:"e14141_client",ctrltype:"textblock"};n[43]={id:43,fld:"",grid:0};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCTECHNICIANPHONE",gxz:"ZV9cTechnicianPhone",gxold:"OV9cTechnicianPhone",gxvar:"AV9cTechnicianPhone",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV9cTechnicianPhone=n)},v2z:function(n){n!==undefined&&(gx.O.ZV9cTechnicianPhone=n)},v2c:function(){gx.fn.setControlValue("vCTECHNICIANPHONE",gx.O.AV9cTechnicianPhone,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV9cTechnicianPhone=this.val())},val:function(){return gx.fn.getControlValue("vCTECHNICIANPHONE")},nac:gx.falseFn};n[47]={id:47,fld:"",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"COUNTRYIDFILTERCONTAINER",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"LBLCOUNTRYIDFILTER",format:1,grid:0,evt:"e15141_client",ctrltype:"textblock"};n[53]={id:53,fld:"",grid:0};n[54]={id:54,fld:"",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCCOUNTRYID",gxz:"ZV10cCountryId",gxold:"OV10cCountryId",gxvar:"AV10cCountryId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV10cCountryId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV10cCountryId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCCOUNTRYID",gx.O.AV10cCountryId,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV10cCountryId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCCOUNTRYID",".")},nac:gx.falseFn};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"CITYIDFILTERCONTAINER",grid:0};n[60]={id:60,fld:"",grid:0};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"LBLCITYIDFILTER",format:1,grid:0,evt:"e16141_client",ctrltype:"textblock"};n[63]={id:63,fld:"",grid:0};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"",grid:0};n[66]={id:66,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Grid1Container],fld:"vCCITYID",gxz:"ZV11cCityId",gxold:"OV11cCityId",gxvar:"AV11cCityId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV11cCityId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV11cCityId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCCITYID",gx.O.AV11cCityId,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV11cCityId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCCITYID",".")},nac:gx.falseFn};n[67]={id:67,fld:"",grid:0};n[68]={id:68,fld:"GRIDTABLE",grid:0};n[69]={id:69,fld:"",grid:0};n[70]={id:70,fld:"",grid:0};n[71]={id:71,fld:"BTNTOGGLE",grid:0,evt:"e17141_client"};n[72]={id:72,fld:"",grid:0};n[73]={id:73,fld:"",grid:0};n[75]={id:75,lvl:2,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:74,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vLINKSELECTION",gxz:"ZV5LinkSelection",gxold:"OV5LinkSelection",gxvar:"AV5LinkSelection",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV5LinkSelection=n)},v2z:function(n){n!==undefined&&(gx.O.ZV5LinkSelection=n)},v2c:function(n){gx.fn.setGridMultimediaValue("vLINKSELECTION",n||gx.fn.currentGridRowImpl(74),gx.O.AV5LinkSelection,gx.O.AV16Linkselection_GXI)},c2v:function(n){gx.O.AV16Linkselection_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.AV5LinkSelection=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vLINKSELECTION",n||gx.fn.currentGridRowImpl(74))},val_GXI:function(n){return gx.fn.getGridControlValue("vLINKSELECTION_GXI",n||gx.fn.currentGridRowImpl(74))},gxvar_GXI:"AV16Linkselection_GXI",nac:gx.falseFn};n[76]={id:76,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:74,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANID",gxz:"Z30TechnicianId",gxold:"O30TechnicianId",gxvar:"A30TechnicianId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A30TechnicianId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z30TechnicianId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANID",n||gx.fn.currentGridRowImpl(74),gx.O.A30TechnicianId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A30TechnicianId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("TECHNICIANID",n||gx.fn.currentGridRowImpl(74),".")},nac:gx.falseFn};n[77]={id:77,lvl:2,type:"char",len:50,dec:0,sign:!1,ro:1,isacc:0,grid:74,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANNAME",gxz:"Z31TechnicianName",gxold:"O31TechnicianName",gxvar:"A31TechnicianName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A31TechnicianName=n)},v2z:function(n){n!==undefined&&(gx.O.Z31TechnicianName=n)},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANNAME",n||gx.fn.currentGridRowImpl(74),gx.O.A31TechnicianName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A31TechnicianName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("TECHNICIANNAME",n||gx.fn.currentGridRowImpl(74))},nac:gx.falseFn};n[78]={id:78,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:74,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANLASTNAME",gxz:"Z32TechnicianLastName",gxold:"O32TechnicianLastName",gxvar:"A32TechnicianLastName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A32TechnicianLastName=n)},v2z:function(n){n!==undefined&&(gx.O.Z32TechnicianLastName=n)},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANLASTNAME",n||gx.fn.currentGridRowImpl(74),gx.O.A32TechnicianLastName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A32TechnicianLastName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("TECHNICIANLASTNAME",n||gx.fn.currentGridRowImpl(74))},nac:gx.falseFn};n[79]={id:79,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:74,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TECHNICIANPHONE",gxz:"Z33TechnicianPhone",gxold:"O33TechnicianPhone",gxvar:"A33TechnicianPhone",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"tel",v2v:function(n){n!==undefined&&(gx.O.A33TechnicianPhone=n)},v2z:function(n){n!==undefined&&(gx.O.Z33TechnicianPhone=n)},v2c:function(n){gx.fn.setGridControlValue("TECHNICIANPHONE",n||gx.fn.currentGridRowImpl(74),gx.O.A33TechnicianPhone,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A33TechnicianPhone=this.val(n))},val:function(n){return gx.fn.getGridControlValue("TECHNICIANPHONE",n||gx.fn.currentGridRowImpl(74))},nac:gx.falseFn};n[80]={id:80,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:74,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COUNTRYID",gxz:"Z12CountryId",gxold:"O12CountryId",gxvar:"A12CountryId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A12CountryId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z12CountryId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("COUNTRYID",n||gx.fn.currentGridRowImpl(74),gx.O.A12CountryId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A12CountryId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("COUNTRYID",n||gx.fn.currentGridRowImpl(74),".")},nac:gx.falseFn};n[81]={id:81,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:74,gxgrid:this.Grid1Container,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CITYID",gxz:"Z24CityId",gxold:"O24CityId",gxvar:"A24CityId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A24CityId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z24CityId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("CITYID",n||gx.fn.currentGridRowImpl(74),gx.O.A24CityId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A24CityId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("CITYID",n||gx.fn.currentGridRowImpl(74),".")},nac:gx.falseFn};n[82]={id:82,fld:"",grid:0};n[83]={id:83,fld:"",grid:0};n[84]={id:84,fld:"BTN_CANCEL",grid:0,evt:"e21141_client"};this.AV6cTechnicianId=0;this.ZV6cTechnicianId=0;this.OV6cTechnicianId=0;this.AV7cTechnicianName="";this.ZV7cTechnicianName="";this.OV7cTechnicianName="";this.AV8cTechnicianLastName="";this.ZV8cTechnicianLastName="";this.OV8cTechnicianLastName="";this.AV9cTechnicianPhone="";this.ZV9cTechnicianPhone="";this.OV9cTechnicianPhone="";this.AV10cCountryId=0;this.ZV10cCountryId=0;this.OV10cCountryId=0;this.AV11cCityId=0;this.ZV11cCityId=0;this.OV11cCityId=0;this.ZV5LinkSelection="";this.OV5LinkSelection="";this.Z30TechnicianId=0;this.O30TechnicianId=0;this.Z31TechnicianName="";this.O31TechnicianName="";this.Z32TechnicianLastName="";this.O32TechnicianLastName="";this.Z33TechnicianPhone="";this.O33TechnicianPhone="";this.Z12CountryId=0;this.O12CountryId=0;this.Z24CityId=0;this.O24CityId=0;this.AV6cTechnicianId=0;this.AV7cTechnicianName="";this.AV8cTechnicianLastName="";this.AV9cTechnicianPhone="";this.AV10cCountryId=0;this.AV11cCityId=0;this.AV12pTechnicianId=0;this.AV5LinkSelection="";this.A30TechnicianId=0;this.A31TechnicianName="";this.A32TechnicianLastName="";this.A33TechnicianPhone="";this.A12CountryId=0;this.A24CityId=0;this.Events={e20142_client:["ENTER",!0],e21141_client:["CANCEL",!0],e17141_client:["'TOGGLE'",!1],e11141_client:["LBLTECHNICIANIDFILTER.CLICK",!1],e12141_client:["LBLTECHNICIANNAMEFILTER.CLICK",!1],e13141_client:["LBLTECHNICIANLASTNAMEFILTER.CLICK",!1],e14141_client:["LBLTECHNICIANPHONEFILTER.CLICK",!1],e15141_client:["LBLCOUNTRYIDFILTER.CLICK",!1],e16141_client:["LBLCITYIDFILTER.CLICK",!1]};this.EvtParms.REFRESH=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV7cTechnicianName",fld:"vCTECHNICIANNAME",pic:""},{av:"AV8cTechnicianLastName",fld:"vCTECHNICIANLASTNAME",pic:""},{av:"AV9cTechnicianPhone",fld:"vCTECHNICIANPHONE",pic:""},{av:"AV10cCountryId",fld:"vCCOUNTRYID",pic:"ZZZ9"},{av:"AV11cCityId",fld:"vCCITYID",pic:"ZZZ9"}],[]];this.EvtParms.START=[[],[{ctrl:"FORM",prop:"Caption"}]];this.EvtParms["'TOGGLE'"]=[[{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("ADVANCEDCONTAINER","Class")',ctrl:"ADVANCEDCONTAINER",prop:"Class"},{ctrl:"BTNTOGGLE",prop:"Class"}]];this.EvtParms["LBLTECHNICIANIDFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class")',ctrl:"TECHNICIANIDFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TECHNICIANIDFILTERCONTAINER","Class")',ctrl:"TECHNICIANIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANID","Visible")',ctrl:"vCTECHNICIANID",prop:"Visible"}]];this.EvtParms["LBLTECHNICIANNAMEFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TECHNICIANNAMEFILTERCONTAINER","Class")',ctrl:"TECHNICIANNAMEFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TECHNICIANNAMEFILTERCONTAINER","Class")',ctrl:"TECHNICIANNAMEFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANNAME","Visible")',ctrl:"vCTECHNICIANNAME",prop:"Visible"}]];this.EvtParms["LBLTECHNICIANLASTNAMEFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TECHNICIANLASTNAMEFILTERCONTAINER","Class")',ctrl:"TECHNICIANLASTNAMEFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TECHNICIANLASTNAMEFILTERCONTAINER","Class")',ctrl:"TECHNICIANLASTNAMEFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANLASTNAME","Visible")',ctrl:"vCTECHNICIANLASTNAME",prop:"Visible"}]];this.EvtParms["LBLTECHNICIANPHONEFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("TECHNICIANPHONEFILTERCONTAINER","Class")',ctrl:"TECHNICIANPHONEFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("TECHNICIANPHONEFILTERCONTAINER","Class")',ctrl:"TECHNICIANPHONEFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCTECHNICIANPHONE","Visible")',ctrl:"vCTECHNICIANPHONE",prop:"Visible"}]];this.EvtParms["LBLCOUNTRYIDFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("COUNTRYIDFILTERCONTAINER","Class")',ctrl:"COUNTRYIDFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("COUNTRYIDFILTERCONTAINER","Class")',ctrl:"COUNTRYIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCCOUNTRYID","Visible")',ctrl:"vCCOUNTRYID",prop:"Visible"}]];this.EvtParms["LBLCITYIDFILTER.CLICK"]=[[{av:'gx.fn.getCtrlProperty("CITYIDFILTERCONTAINER","Class")',ctrl:"CITYIDFILTERCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("CITYIDFILTERCONTAINER","Class")',ctrl:"CITYIDFILTERCONTAINER",prop:"Class"},{av:'gx.fn.getCtrlProperty("vCCITYID","Visible")',ctrl:"vCCITYID",prop:"Visible"}]];this.EvtParms.LOAD=[[],[{av:"AV5LinkSelection",fld:"vLINKSELECTION",pic:""}]];this.EvtParms.ENTER=[[{av:"A30TechnicianId",fld:"TECHNICIANID",pic:"ZZZ9",hsh:!0}],[{av:"AV12pTechnicianId",fld:"vPTECHNICIANID",pic:"ZZZ9"}]];this.EvtParms.GRID1_FIRSTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV7cTechnicianName",fld:"vCTECHNICIANNAME",pic:""},{av:"AV8cTechnicianLastName",fld:"vCTECHNICIANLASTNAME",pic:""},{av:"AV9cTechnicianPhone",fld:"vCTECHNICIANPHONE",pic:""},{av:"AV10cCountryId",fld:"vCCOUNTRYID",pic:"ZZZ9"},{av:"AV11cCityId",fld:"vCCITYID",pic:"ZZZ9"}],[]];this.EvtParms.GRID1_PREVPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV7cTechnicianName",fld:"vCTECHNICIANNAME",pic:""},{av:"AV8cTechnicianLastName",fld:"vCTECHNICIANLASTNAME",pic:""},{av:"AV9cTechnicianPhone",fld:"vCTECHNICIANPHONE",pic:""},{av:"AV10cCountryId",fld:"vCCOUNTRYID",pic:"ZZZ9"},{av:"AV11cCityId",fld:"vCCITYID",pic:"ZZZ9"}],[]];this.EvtParms.GRID1_NEXTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV7cTechnicianName",fld:"vCTECHNICIANNAME",pic:""},{av:"AV8cTechnicianLastName",fld:"vCTECHNICIANLASTNAME",pic:""},{av:"AV9cTechnicianPhone",fld:"vCTECHNICIANPHONE",pic:""},{av:"AV10cCountryId",fld:"vCCOUNTRYID",pic:"ZZZ9"},{av:"AV11cCityId",fld:"vCCITYID",pic:"ZZZ9"}],[]];this.EvtParms.GRID1_LASTPAGE=[[{av:"GRID1_nFirstRecordOnPage"},{av:"GRID1_nEOF"},{ctrl:"GRID1",prop:"Rows"},{av:"AV6cTechnicianId",fld:"vCTECHNICIANID",pic:"ZZZ9"},{av:"AV7cTechnicianName",fld:"vCTECHNICIANNAME",pic:""},{av:"AV8cTechnicianLastName",fld:"vCTECHNICIANLASTNAME",pic:""},{av:"AV9cTechnicianPhone",fld:"vCTECHNICIANPHONE",pic:""},{av:"AV10cCountryId",fld:"vCCOUNTRYID",pic:"ZZZ9"},{av:"AV11cCityId",fld:"vCCITYID",pic:"ZZZ9"}],[]];this.setVCMap("AV12pTechnicianId","vPTECHNICIANID",0,"int",4,0);t.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid1"});t.addRefreshingVar(this.GXValidFnc[16]);t.addRefreshingVar(this.GXValidFnc[26]);t.addRefreshingVar(this.GXValidFnc[36]);t.addRefreshingVar(this.GXValidFnc[46]);t.addRefreshingVar(this.GXValidFnc[56]);t.addRefreshingVar(this.GXValidFnc[66]);t.addRefreshingParm(this.GXValidFnc[16]);t.addRefreshingParm(this.GXValidFnc[26]);t.addRefreshingParm(this.GXValidFnc[36]);t.addRefreshingParm(this.GXValidFnc[46]);t.addRefreshingParm(this.GXValidFnc[56]);t.addRefreshingParm(this.GXValidFnc[66]);this.Initialize()});gx.wi(function(){gx.createParentObj(this.gx0090)})
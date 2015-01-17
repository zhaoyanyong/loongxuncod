/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : yqtbase

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2014-12-14 16:32:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attributeh`
-- ----------------------------
DROP TABLE IF EXISTS `attributeh`;
CREATE TABLE `attributeh` (
  `AttributeId` int(11) NOT NULL AUTO_INCREMENT,
  `EnterpriseId` int(11) DEFAULT NULL,
  `TotalNetAssets` int(11) DEFAULT NULL,
  `TotalCapitalAsserts` double DEFAULT NULL,
  `OperatingReceipt` double DEFAULT NULL COMMENT '??',
  `TotalTaxProfit` double DEFAULT NULL,
  `CapitalAssertsNetValue` double DEFAULT NULL,
  `FloatingCapital` double DEFAULT NULL,
  `CashLiabilities` double DEFAULT NULL,
  `GeneralCash` double DEFAULT NULL,
  `ShortTermBondInvestment` double DEFAULT NULL,
  `AccountReceivable` double DEFAULT NULL,
  `NoteReceivable` double DEFAULT NULL,
  `ValueSecurities` double DEFAULT NULL,
  `GrossLiabilities` double DEFAULT NULL,
  `TotalAssets` double DEFAULT NULL,
  `EarningsInterestTaxes` double DEFAULT NULL,
  `CapitalCharges` double DEFAULT NULL,
  `ForeignGuaranteeAmount` double DEFAULT NULL,
  `SalesProceed` double DEFAULT NULL,
  `MainBusinessNetIncome` double DEFAULT NULL,
  `BeginTotalCurrentAssets` double DEFAULT NULL,
  `EndTotalCurrentAssets` double DEFAULT NULL,
  `FixedAssets` double DEFAULT NULL,
  `BeginTotalAccountsReceivable` double DEFAULT NULL,
  `EndTotalAccountsReceivable` double DEFAULT NULL,
  `SellingCost` double DEFAULT NULL,
  `BeginningInventory` double DEFAULT NULL,
  `EndInventory` double DEFAULT NULL,
  `BeginOwnerEquity` double DEFAULT NULL,
  `EndOwnerEquity` double DEFAULT NULL,
  `BeginSalesProceed` double DEFAULT NULL,
  `EndSalesProceed` double DEFAULT NULL,
  `NetIncomeRetainedAfterTax` double DEFAULT NULL,
  `NetAssets` double DEFAULT NULL,
  `TotalProfit` double DEFAULT NULL,
  `TotalCost` double DEFAULT NULL,
  `MainOperationIncome` double DEFAULT NULL,
  `CostOfSales` double DEFAULT NULL,
  `SalesTax` double DEFAULT NULL,
  `TotalAssetGrowth` double DEFAULT NULL,
  `BeginTotalAssets` double DEFAULT NULL,
  `BeginNetAssets` double DEFAULT NULL,
  `EndNetAssets` double DEFAULT NULL,
  `BeginBusinessReceipt` double DEFAULT NULL,
  `EndBusinessReceipt` double DEFAULT NULL,
  `BeginNonrevenueReceipt` double DEFAULT NULL,
  `EndNonrevenueReceipt` double DEFAULT NULL,
  `IncomeTax` double DEFAULT NULL,
  `EmployeNumCurrentYear` int(11) DEFAULT NULL,
  `EmployeNumLastYear` int(11) DEFAULT NULL,
  `AgeGroup` int(11) DEFAULT NULL,
  `DegreeTitles` int(11) DEFAULT NULL,
  `WorkingTime` double DEFAULT NULL,
  `Reputations` int(11) DEFAULT NULL,
  `EnterpriseExpansionProjects` tinyint(4) DEFAULT NULL,
  `ProducLongTermDevelopment` tinyint(4) DEFAULT NULL,
  `ProductQualityCertification` tinyint(4) DEFAULT NULL,
  `LndustryProperties` int(11) DEFAULT NULL,
  `YearNewSalesIncome` double DEFAULT NULL,
  `YearGrossSales` double DEFAULT NULL,
  `AppropriationExpenditure` double DEFAULT NULL,
  `BeginFundingAmount` double DEFAULT NULL,
  `EndFundingAmount` double DEFAULT NULL,
  `AboveCollegeEmployeeNum` int(11) DEFAULT NULL,
  `ScientificRewardsNum` int(11) DEFAULT NULL,
  `IntellectualPropertyRightNum` int(11) DEFAULT NULL,
  `PatentNum` int(11) DEFAULT NULL,
  `CouontryGovernmentProjectNum` int(11) DEFAULT NULL,
  `ProvinceGovernmentprojectNum` int(11) DEFAULT NULL,
  `CityGovernmentprojectNum` int(11) DEFAULT NULL,
  `IncentiveSystemOfInnovation` tinyint(4) DEFAULT NULL,
  `Researchinstitute` tinyint(4) DEFAULT NULL,
  `VentureCapitalInstitutions` tinyint(4) DEFAULT NULL,
  `InternationallyCooperative` tinyint(4) DEFAULT NULL,
  `StateKeyLaboratory` tinyint(4) DEFAULT NULL,
  `GrossInterest` double DEFAULT NULL,
  `OverdueLoans` double DEFAULT NULL,
  `LoanCeiling` double DEFAULT NULL,
  `AlreadyPaidCredit` double DEFAULT NULL,
  `ShouldPaidCredit` double DEFAULT NULL,
  `PersonalReputation` int(11) DEFAULT NULL,
  `OperationControl` int(11) DEFAULT NULL,
  `ShareholdersBackground` int(11) DEFAULT NULL,
  `TakeOfficeYear` int(11) DEFAULT NULL,
  `BoardOfDirectors` int(11) DEFAULT NULL,
  `CeosetupStatus` int(11) DEFAULT NULL,
  `AuditOpinion` int(11) DEFAULT NULL,
  `Irregularities` int(11) DEFAULT NULL,
  `StateIndustrialPolicies` int(11) DEFAULT NULL,
  `IndustryPosition` int(11) DEFAULT NULL,
  `LeadingIndustry` int(11) DEFAULT NULL,
  `ProductCompetitiveness` int(11) DEFAULT NULL,
  `EndTotalAssets` double DEFAULT NULL,
  `LastTotalProfit` double DEFAULT NULL,
  `LastIncomeTax` double DEFAULT NULL,
  `AcademicTitle` int(11) DEFAULT NULL,
  `BeginMainOperationIncome` double DEFAULT NULL,
  `EndMainOperationIncome` double DEFAULT NULL,
  `BeginCostOfSales` double DEFAULT NULL,
  `EndCostOfSales` double DEFAULT NULL,
  `BeginSalesTax` double DEFAULT NULL,
  `EndSalesTax` double DEFAULT NULL,
  `CreateTime` varchar(24) DEFAULT NULL,
  `InterestExpense` decimal(10,0) DEFAULT NULL,
  `shareholderNameOne` varchar(32) DEFAULT NULL,
  `shareholdingRatioOne` double DEFAULT NULL,
  `shareholderNameTwo` varchar(32) DEFAULT NULL,
  `shareholderNameThree` varchar(32) DEFAULT NULL,
  `shareholdingRatioThree` double DEFAULT NULL,
  `shareholdingRatioTwo` double DEFAULT NULL,
  `shareholdingRatioFour` double DEFAULT NULL,
  `shareholderNameFour` varchar(32) DEFAULT NULL,
  `shareholderNameFive` varchar(32) DEFAULT NULL,
  `shareholdingRatioFive` double DEFAULT NULL,
  `IinfoDisclosure` varchar(200) DEFAULT NULL,
  `managerAge` int(11) DEFAULT NULL,
  `eduBackground` int(11) DEFAULT NULL,
  `totalEmployees` int(11) DEFAULT NULL,
  PRIMARY KEY (`AttributeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of attributeh
-- ----------------------------

-- ----------------------------
-- Table structure for `enterprise_info`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_info`;
CREATE TABLE `enterprise_info` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `EPName` varchar(32) NOT NULL COMMENT '企业名称',
  `OrgNo` varchar(16) NOT NULL COMMENT '机构代码',
  `Username` varchar(16) NOT NULL COMMENT '企业账号',
  `Address` varchar(100) NOT NULL COMMENT '企业地址',
  `Postcode` varchar(8) NOT NULL COMMENT '邮政编号',
  `RegistAddress` varchar(100) NOT NULL COMMENT '注册地址',
  `RegistMoney` double(10,0) NOT NULL COMMENT '注册资金',
  `Contacts` varchar(16) NOT NULL COMMENT '企业联系人',
  `ContactPhone` varchar(32) NOT NULL COMMENT '联系人电话',
  `ContactEmail` varchar(32) NOT NULL COMMENT '联系人邮箱',
  `LegalPerson` varchar(32) NOT NULL COMMENT '企业法人代表',
  `LegalPhone` varchar(32) NOT NULL COMMENT '法人代表电话',
  `LegalEmail` varchar(32) NOT NULL COMMENT '法人代表邮箱',
  `Area` int(8) NOT NULL COMMENT '企业所属地区',
  `Profession` int(8) NOT NULL COMMENT '企业所属行业',
  `Property` int(8) NOT NULL COMMENT '企业所属性质',
  `Charac` int(8) DEFAULT NULL COMMENT '企业所属特性',
  `Staff` varchar(8) NOT NULL COMMENT '企业员工总数',
  `ColleageStaff` varchar(8) NOT NULL COMMENT '大专及以上毕业生的员工数',
  `TechnicalStaff` varchar(8) NOT NULL COMMENT '技术人员数量',
  `ManageStaff` varchar(8) NOT NULL COMMENT '管理人员数量',
  `Stage` int(8) NOT NULL COMMENT '生命周期1:初创期   2:发展期  3：稳定期',
  `IsHeavyIndustry` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否为重工业',
  `OtherProperty` varchar(100) DEFAULT NULL COMMENT '其他企业性质',
  `OtherCharac` varchar(100) DEFAULT NULL COMMENT '其他企业特性',
  `CreateTime` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `DeleteFlag` int(1) DEFAULT '0' COMMENT '删除标志0：正常；1：删除',
  `License` varchar(32) DEFAULT NULL,
  `Tax` varchar(32) DEFAULT NULL,
  `OrgNoUrl` varchar(200) DEFAULT NULL,
  `TaxUrl` varchar(200) DEFAULT NULL,
  `LicenseUrl` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of enterprise_info
-- ----------------------------

-- ----------------------------
-- Table structure for `loginfo`
-- ----------------------------
DROP TABLE IF EXISTS `loginfo`;
CREATE TABLE `loginfo` (
  `LogId` int(11) NOT NULL AUTO_INCREMENT,
  `Opreation` varchar(100) DEFAULT NULL,
  `UserName` varchar(32) DEFAULT NULL,
  `OpreationDate` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`LogId`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of loginfo
-- ----------------------------
INSERT INTO `loginfo` VALUES ('138', '账号：yinqitong，登录成功', 'yinqitong', '2014-12-14 16:26:48');
INSERT INTO `loginfo` VALUES ('139', '账号：yinqitong，在另一处登录成功', 'yinqitong', '2014-12-14 16:30:05');
INSERT INTO `loginfo` VALUES ('140', '账号：yinqitong，登录成功', 'yinqitong', '2014-12-14 16:30:50');
INSERT INTO `loginfo` VALUES ('141', '账号：guangfa，登录成功', 'guangfa', '2014-12-14 16:31:14');

-- ----------------------------
-- Table structure for `rights`
-- ----------------------------
DROP TABLE IF EXISTS `rights`;
CREATE TABLE `rights` (
  `RightsId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Ȩ',
  `RightsName` varchar(64) DEFAULT NULL COMMENT 'Ȩ',
  `RightsUrl` varchar(128) DEFAULT NULL,
  `CreateTime` varchar(32) DEFAULT NULL,
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT 'ɾ',
  PRIMARY KEY (`RightsId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='Ȩ';

-- ----------------------------
-- Records of rights
-- ----------------------------
INSERT INTO `rights` VALUES ('3', '政府公开信息查询<企业信用>', 'zfgkxxcx', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('4', '政府公开信息录入<企业信用>', 'zfgkxxlr', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('5', '生产经营信息查询<企业信用>', 'scjyxxcx', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('6', '生产经营信息录入<企业信用>', 'scjyxxlr', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('7', '财务管理信息查询<企业信用>', 'cwglxxcx', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('8', '财务管理信息录入<企业信用>', 'cwglxxlr', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('9', '投融资信息查询<企业信用>', 'trzxxcx', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('10', '投融资信息录入<企业信用>', 'trzxxlr', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('11', '企业文化信息查询<企业信用>', 'qywhxxcx', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('12', '企业文化信息录入<企业信用>', 'qywhxxlr', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('13', '社会公众信息查询<企业信用>', 'shgzxxcx', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('14', '社会公众信息录入<企业信用>', 'shgzxxlr', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('15', '定量数据查看<数据分析>', 'dlsjck', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('16', '定性数据查看<数据分析>', 'dxsjck', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('17', '评定介绍<信用评定>', 'pdjs', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('18', '评定查询<信用评定>', 'pkcx', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('19', '用户列表<系统设置>', 'yhlb', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('20', '角色列表<系统设置>', 'jslb', '2014-12-11', '0');
INSERT INTO `rights` VALUES ('21', '日志列表<系统设置>', 'rzlb', '2014-12-11', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(64) DEFAULT NULL,
  `Remark` varchar(256) DEFAULT NULL,
  `CreateTime` varchar(32) DEFAULT NULL,
  `IsDelete` tinyint(1) DEFAULT NULL COMMENT 'ɾ',
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理员', '2014-12-11', '0');
INSERT INTO `role` VALUES ('2', '企业用户', '企业', '2014-12-11', '0');
INSERT INTO `role` VALUES ('3', '银行用户', '银行', '2014-12-11', '0');

-- ----------------------------
-- Table structure for `rolerights`
-- ----------------------------
DROP TABLE IF EXISTS `rolerights`;
CREATE TABLE `rolerights` (
  `RrId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) DEFAULT NULL,
  `RightsId` int(11) DEFAULT NULL COMMENT 'Ȩ',
  PRIMARY KEY (`RrId`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of rolerights
-- ----------------------------
INSERT INTO `rolerights` VALUES ('73', '1', '3');
INSERT INTO `rolerights` VALUES ('74', '1', '4');
INSERT INTO `rolerights` VALUES ('75', '1', '5');
INSERT INTO `rolerights` VALUES ('76', '1', '6');
INSERT INTO `rolerights` VALUES ('77', '1', '7');
INSERT INTO `rolerights` VALUES ('78', '1', '8');
INSERT INTO `rolerights` VALUES ('79', '1', '9');
INSERT INTO `rolerights` VALUES ('80', '1', '10');
INSERT INTO `rolerights` VALUES ('81', '1', '11');
INSERT INTO `rolerights` VALUES ('82', '1', '12');
INSERT INTO `rolerights` VALUES ('83', '1', '13');
INSERT INTO `rolerights` VALUES ('84', '1', '14');
INSERT INTO `rolerights` VALUES ('85', '1', '15');
INSERT INTO `rolerights` VALUES ('86', '1', '16');
INSERT INTO `rolerights` VALUES ('87', '1', '17');
INSERT INTO `rolerights` VALUES ('88', '1', '18');
INSERT INTO `rolerights` VALUES ('89', '1', '19');
INSERT INTO `rolerights` VALUES ('90', '1', '20');
INSERT INTO `rolerights` VALUES ('91', '1', '21');
INSERT INTO `rolerights` VALUES ('102', '3', '3');
INSERT INTO `rolerights` VALUES ('103', '3', '5');
INSERT INTO `rolerights` VALUES ('104', '3', '7');
INSERT INTO `rolerights` VALUES ('105', '3', '9');
INSERT INTO `rolerights` VALUES ('106', '3', '11');
INSERT INTO `rolerights` VALUES ('107', '3', '13');
INSERT INTO `rolerights` VALUES ('108', '3', '15');
INSERT INTO `rolerights` VALUES ('109', '3', '16');
INSERT INTO `rolerights` VALUES ('110', '3', '17');
INSERT INTO `rolerights` VALUES ('111', '3', '18');
INSERT INTO `rolerights` VALUES ('112', '2', '3');
INSERT INTO `rolerights` VALUES ('113', '2', '4');
INSERT INTO `rolerights` VALUES ('114', '2', '5');
INSERT INTO `rolerights` VALUES ('115', '2', '6');
INSERT INTO `rolerights` VALUES ('116', '2', '7');
INSERT INTO `rolerights` VALUES ('117', '2', '8');
INSERT INTO `rolerights` VALUES ('118', '2', '9');
INSERT INTO `rolerights` VALUES ('119', '2', '10');
INSERT INTO `rolerights` VALUES ('120', '2', '11');
INSERT INTO `rolerights` VALUES ('121', '2', '12');
INSERT INTO `rolerights` VALUES ('122', '2', '13');
INSERT INTO `rolerights` VALUES ('123', '2', '14');
INSERT INTO `rolerights` VALUES ('124', '2', '15');
INSERT INTO `rolerights` VALUES ('125', '2', '16');
INSERT INTO `rolerights` VALUES ('126', '2', '17');
INSERT INTO `rolerights` VALUES ('127', '2', '18');

-- ----------------------------
-- Table structure for `userbase`
-- ----------------------------
DROP TABLE IF EXISTS `userbase`;
CREATE TABLE `userbase` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AdminName` varchar(24) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Aname` varchar(24) DEFAULT NULL,
  `Sex` varchar(4) DEFAULT NULL,
  `IsDelete` int(11) DEFAULT NULL,
  `CreateTime` varchar(24) DEFAULT NULL,
  `UserType` int(11) DEFAULT NULL,
  `Remarks` varchar(128) DEFAULT NULL,
  `RoleId` int(11) DEFAULT NULL,
  `LockTime` varchar(24) DEFAULT '0',
  `inputNumber` int(5) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of userbase
-- ----------------------------
INSERT INTO `userbase` VALUES ('1', 'yinqitong', '537099b56ea4d1932e689866b5087fc7', '银企通', '0', '0', '2014-12-11 14:04:18', '1', '', '1', '0', '1');
INSERT INTO `userbase` VALUES ('2', 'guangfa', 'dffc5417aca85091a30cc63cf69a0742', '广发', '0', '0', '2014-12-11 14:04:18', '3', null, '3', '0', '0');

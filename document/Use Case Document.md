#用例文档

## 目录

[TOC]

## 更新历史

| 修改人员           | 日期        | 变更原因 | 版本号  |
| -------------- | --------- | ---- | ---- |
| 訾源，高梦婷，陈俊宇，廖均达 | 2017.9.23 | 整合   | 1.0  |
|                |           |      |      |
|                |           |      |      |

## 引言

### 目的

本文档描述了某灯具照明公司进销存管理系统的用户需求

## 用例列表

| 参与者    | 用例                                       |
| ------ | ---------------------------------------- |
| 库存管理人员 | 1.商品分类管理<br>2.商品管理<br>3.库存查看<br>4.库存盘点<br>5.创建库存赠送单 |
|        | 6.创建库存报溢/报损单<br>7.创建库存报警单<br>8.处理消息      |
| 进货销售人员 | 9.客户管理<br>10.制定进货单<br>11.制定进货退货单         |
|        | 12.制定销售单<br>13.制定销售退货单                   |
| 财务人员   | 14.账户管理<br>15.制定收付款单<br>16.制定现金费用单<br>17.期初建账 |
|        | 19.查看销售明细表<br>20.查看经营历程<br>21.查看经营情况表    |
| 总经理    | 18.审批单据<br>19.查看销售明细表<br>20.查看经营历程<br>21.查看经营情况表 |
|        | 22.制定促销策略<br>23.查询日志                     |
| 管理员    | 24.管理系统用户信息                              |



## 详细用例描述

### 用例1

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 1                                        |
|  创建者   | 訾源                                       |
|   时间   | 2017.9.10                                |
|   名称   | 商品分类管理                                   |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 库存管理人员。目的是为了简便、规范化的完成商品分类的管理，包括增加分类、删除分类、修改分类。 |
|  触发条件  | 库存管理人员对商品分类进行管理。                         |
|  前置条件  | 当前登录账号为库存管理人员账号，身份已验证无误。                 |
|  后置条件  | 系统保存新商品分类管理信息。                           |
|  优先级   | 中                                        |
|  正常流程  | 1 系统以树状结构显示当前的商品分类信息。<br> 2 库存管理人员根据需求对商品分类进行操作。<br> 3 保存最新的商品分类信息，系统提示成功。 |
|  扩展流程  | 2a. 在已经存在商品的分类下添加子分类：<br><t>   系统提示分类添加出错信息，返回正常流程第一步。<br> 2b. 删除已经存在商品的分类：<br><t>   系统提示分类删除出错信息，返回正常流程第一步。<br> 2c. 添加已经存在的分类：<br><t>   系统提示分类添加出错信息，返回正常流程第一步。<br> 3a. 信息保存失败：<br><t>   系统提示保存失败，显示具体错误原因，返回正常流程第二步，即提交之前的分类状态。 |
|  特殊需求  | 简单易用，无操作难度。                              |

### 用例2

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 2                                        |
|  创建者   | 訾源                                       |
|   时间   | 2017.9.10                                |
|   名称   | 商品管理                                     |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 库存管理人员。目的是为了简便、规范化的完成商品的管理，包括增加商品、删除商品、修改商品以及查询商品。 |
|  触发条件  | 库存管理人员对商品进行管理。                           |
|  前置条件  | 当前登录账号为库存管理人员账号，身份已验证无误。                 |
|  后置条件  | 系统保存最新新商品信息。                             |
|  优先级   | 高                                        |
|  正常流程  | 1 系统以树状结构显示各个分类下商品的属性，包括编号、名称、型号、库存数量、进价、零售价、最近进价、最近零售价。<br> 2 库存管理人员根据需求对商品进行操作，包括增删改查四种操作，其中查询可以通过关键字查询，也可以通过编号查询。<br> 3 保存最新的商品，系统提示成功。 |
|  扩展流程  | 2a. 添加已有的商品（根据商品名称、型号来进行确定是否相同）：<br><t>   系统提示商品添加出错信息，返回正常流程第一步。<br> 2b. 修改商品信息时出现不合法内容：<br><t>   系统提示商品信息修改错误原因，返回正常流程第一步。<br> 3a. 信息保存失败：<br><t>   系统提示保存失败，显示具体错误原因，返回正常流程第二步，即提交之前的商品状态。 |
|  特殊需求  | 简单易用，无操作难度。                              |

### 用例3

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 3                                        |
|  创建者   | 訾源                                       |
|   时间   | 2017.9.10                                |
|   名称   | 库存查看                                     |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 库存管理人员。目的是为了简便、快速的查看库存信息。                |
|  触发条件  | 库存管理人员对库存进行查看。                           |
|  前置条件  | 当前登录账号为库存管理人员账号，身份已验证无误。                 |
|  后置条件  | 无                                        |
|  优先级   | 中                                        |
|  正常流程  | 1 库存管理人员选择一个时间段。<br> 2 系统显示该时间段内的各条出/入库数量/金额，销售/进货的数量/金额，以及各项的合计信息。 |
|  扩展流程  | 1a. 选择截止时间早于开始时间或截止时间晚于当前时间：<br><t>   系统提示时间非法，返回正常流程的步骤一。 |
|  特殊需求  | 简单易用，无操作难度。                              |

### 用例4

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 4                                        |
|  创建者   | 訾源                                       |
|   时间   | 2017.9.10                                |
|   名称   | 库存盘点                                     |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 库存管理人员。目的是为了快速、方便的完成库存盘点。                |
|  触发条件  | 库存管理人员对库存进行盘点。                           |
|  前置条件  | 当前登录账号为库存管理人员账号，身份已验证无误。                 |
|  后置条件  | 无                                        |
|  优先级   | 高                                        |
|  正常流程  | 1 系统显示当天的库存快照，包括当天的各种商品的名称，型号，库存数量，库存均价，批次，批号，出厂日期，并且显示行号。 |
|  扩展流程  | 1a. 库存管理员选择导出Excel文件：<br><t>   系统在库存管理人员选择的目录下生产Excel文件。 |
|  特殊需求  | 简单易用，无操作难度。<br> 可以将库存快照导出Excel文件。        |

### 用例5

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 5                                        |
|  创建者   | 訾源                                       |
|   时间   | 2017.9.10                                |
|   名称   | 创建库存赠送单                                  |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 库存管理人员。目的是为了简便、规范化的创建库存赠送单。              |
|  触发条件  | 库存管理人员创建库存赠送单。                           |
|  前置条件  | 当前登录账号为库存管理人员账号，身份已验证无误。                 |
|  后置条件  | 从库存中减去赠送品，修改保存库存信息。                      |
|  优先级   | 低                                        |
|  正常流程  | 1 库存管理人员选择赠送的商品、商品数量、受赠者。<br> 2 提交单据。    |
|  扩展流程  | 1a. 商品数量不合法：<br><t>   系统提示数量不合法，显示当前该类商品数量，返回正常流程第一步。<br> 1b. 输入非法字符：<br><t>   系统提示输入不合法，返回正常流程第一步。<br> 2a. 单据提交失败：<br><t>   系统提示单据提交失败，显示具体错误原因，返回正常流程第一步。 |
|  特殊需求  | 简单易用，无操作难度。                              |

### 用例6

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 6                                        |
|  创建者   | 訾源                                       |
|   时间   | 2017.9.10                                |
|   名称   | 创建库存报溢/报损单                               |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 库存管理人员。目的是为了简便、规范化的创建库存报溢/报损单。           |
|  触发条件  | 库存管理人员发现当前库存与系统中存储的数量不匹配。                |
|  前置条件  | 当前登录账号为库存管理人员账号，身份已验证无误。                 |
|  后置条件  | 更新库存信息。                                  |
|  优先级   | 中                                        |
|  正常流程  | 1 库存管理人员选择的商品。<br> 2 输入当前产品的实际数量。<br> 3 提交单据。 |
|  扩展流程  | 2a. 商品数量不合法（如输入小于零的数）：<br><t>   系统提示数量不合法，返回正常流程第一步。<br> 2b. 输入非法字符：<br><t>   系统提示输入不合法，返回正常流程第一步。<br> 3a. 单据提交失败：<br><t>   系统提示单据提交失败，显示具体错误原因，返回正常流程第一步。 |
|  特殊需求  | 简单易用，无操作难度。                              |

### 用例7

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 7                                        |
|  创建者   | 訾源                                       |
|   时间   | 2017.9.10                                |
|   名称   | 创建库存报警单                                  |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 库存管理人员。目的是为了简便地设置一个警戒数量，进行库存预警。          |
|  触发条件  | 库存管理人员创建库存报警单。                           |
|  前置条件  | 当前登录账号为库存管理人员账号，身份已验证无误。                 |
|  后置条件  | 报警单存储。等待触发。                              |
|  优先级   | 中                                        |
|  正常流程  | 1 库存管理人员选择商品，警戒数量。<br> 2 提交单据。           |
|  扩展流程  | 1a. 商品数量不合法：<br><t>   系统提示数量不合法，显示当前该类商品数量，返回正常流程第一步。<br>  1b. 输入非法字符：<br><t>   系统提示输入不合法，返回正常流程第一步。<br> 2a. 单据提交失败：<br><t>   系统提示单据提交失败，显示具体错误原因，返回正常流程第一步。 |
|  特殊需求  | 简单易用，无操作难度。                              |

### 用例8

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 8                                        |
|  创建者   | 訾源                                       |
|   时间   | 2017.9.10                                |
|   名称   | 处理消息                                     |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 库存管理人员。目的是处理当前接收到的系统消息，包括库存报警信息、进货单等。    |
|  触发条件  | 库存管理人员处理信息。                              |
|  前置条件  | 当前登录账号为库存管理人员账号，身份已验证无误。                 |
|  后置条件  | 消息被处理，从未处理的消息队列中移除。                      |
|  优先级   | 高                                        |
|  正常流程  | 1 库存管理人员打开消息队列。<br> 2 选择某一条消息。<br> 3 处理消息/阅读消息。<br> 4 消息成功处理过后，标记该消息，消息将从未读消息中移除。 |
|  扩展流程  |                                          |
|  特殊需求  | 简单易用。                                    |

### 用例9

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 9                                        |
|  创建者   | 高梦婷                                      |
|   时间   | 2017.9.11                                |
|   名称   | 客户管理                                     |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 销售人员，目标是有效的管理客户信息                        |
|  触发条件  | 客户信息的变化；需要核实查找客户信息                       |
|  前置条件  | 销售人员必须已经被识别或授权                           |
|  后置条件  | 存储更新客户的信息                                |
|  优先级   | 高                                        |
|  正常流程  | 1.销售人员打开客户管理界面，系统生成并显示客户属性列表，显示管理按钮<br>2.销售人员开始管理<br>2.1销售人员选择“增加客户”，系统显示客户信息界面并填充客户编号<br>2.1.1销售人员选择分类和级别，输入剩余客户属性，完成之后请求保存<br>2.1.2系统保存新建的客户信息并更新客户列表<br>2.2销售人员在查找框里输入客户编号或关键字，系统以列表形式显示查找结果<br>2.3销售人员点选一个客户，系统显示客户具体信息界面<br>2.3.1销售人员选择编辑客户信息<br>2.3.1.1若是最高权限，系统显示允许销售人员更改客户除应收、应付的其他属性<br>2.3.1.2若不是最高权限，系统显示允许销售人员更改客户除应收、应付、应收额度的其他属性<br>2.3.1.4销售人员编辑完成，系统更新客户信息和客户列表<br>2.3.2销售人员选择删除客户信息，系统删除客户信息并更新客户列表<br>2.4销售人员选择返回，系统返回客户管理界面 |
|   扩展   | 2.1.1a.销售人员增加已经存在的客户<br>1.系统拒绝添加并提示客户已经存在<br>2.2a.非法关键字<br>1.系统提示错误并拒绝输入<br>2.2b.非法客户编号<br>1.系统提示错误并拒绝输入<br>2.3a.销售人员选择返回<br>1.系统关闭客户信息界面并返回客户管理界面<br>2.3.1.4a.输入非法应收额度<br>1.系统提示错误并拒绝输入<br>2.3.1.4b.销售人员选择返回<br>1.系统关闭客户信息界面并返回客户管理界面 |
|  特殊需求  | 1.客户的属性有：编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员<br>2.查询客户可以通过输入关键字、客户编号等进行查找<br>3.操作简单容易上手 |

### 用例10

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 10                                       |
|  创建者   | 高梦婷                                      |
|   时间   | 2017.9.11                                |
|   名称   | 制定进货单                                    |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 销售人员，目标是及时的完成进货                          |
|  触发条件  | 缺少库存；市场有进货需求                             |
|  前置条件  | 销售人员必须已经被识别或授权                           |
|  后置条件  | 制定的进货单等待审批                               |
|  优先级   | 中                                        |
|  正常流程  | 1.销售人员新建一个进货单<br>2.系统显示一个新进货单，包括：单据编号，供应商，仓库，操作员，入库商品列表，备注，总额合计。其中入库商品列表包含的信息有：商品编号，名称，型号，数量，单价，金额，备注<br>3.系统自动计算并生成除名称、数量、备注等的其余部分<br>4.销售人员手动输入、添加、选择入库商品列表中的名称、数量、备注等<br>5.系统重新计算并生成显示进货单<br>6.重复4~5步直至销售人员完成进货单<br>7.系统生成最终进货单并显示 |
|  扩展流程  | 4a.销售人员更改单价<br>1.系统更改进货单中的单价并显示<br>4b.非法数量格式<br>2.系统提示数量格式错误 |
|  特殊需求  | 1.单据编号格式为：JHD-yyyyMMdd-xxxxx，后五位每天从1开始编号，所以一天最多可以生成99999条单子<br>2.名称从商品选择界面进行选择<br>3.单价默认为商品信息中的进价<br>4.进货单通过审批后，会更改库存数据和客户的应收应付数据<br>5.操作简单容易上手 |

### 用例11

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 11                                       |
|  创建者   | 高梦婷                                      |
|   时间   | 2017.9.11                                |
|   名称   | 制定进货退货单                                  |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 销售人员，目标是及时向供应商退货                         |
|  触发条件  | 已经进货的商品出现问题；库存爆满；市场需求降低等                 |
|  前置条件  | 销售人员必须已经被识别或授权                           |
|  后置条件  | 制定的退货单等待审批                               |
|  优先级   | 高                                        |
|  正常流程  | 1.销售人员新建一个进货退货单<br>2.系统显示一个新进货退货单，包括：单据编号，供应商，仓库，操作员，入库商品列表，备注，总额合计。其中入库商品列表包含的信息有：商品编号，名称，型号，数量，单价，金额，备注<br>3.系统自动计算并显示除名称、数量、备注的其余部分<br>4.销售人员在入库商品列表中的手动输入添加其名称、数量、备注等<br>5.系统重新计算并生成进货退货单<br>6.重复4~5步直到销售人员完成进货退货单<br>7.系统生成并显示最终进货退货单 |
|  扩展流程  | 4a.销售人员更改入库商品列表的单价<br>1.系统更改进货退货单中的单价并显示<br>4b.非法数量格式<br>1.系统提示数量格式错误 |
|  特殊需求  | 1.单据编号格式为：JHTHD-yyyyMMdd-xxxxx，后五位每天从1开始编号，所以一天最多可以生成99999条单子<br>2.名称从商品选择界面进行选择<br>3.单价默认为商品信息中的进价<br>4.进货退货单通过审批后，会更改库存数据和客户的应收应付数据<br>5.操作简单容易上手 |

### 用例12

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 12                                       |
|  创建者   | 高梦婷                                      |
|   时间   | 2017.9.11                                |
|   名称   | 制定销售单                                    |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 销售人员，目标是及时有效的完成销售                        |
|  触发条件  | 公司收到订单                                   |
|  前置条件  | 销售人员必须已经被识别或授权                           |
|  后置条件  | 生成一个销售出货单，等待审批                           |
|  优先级   | 高                                        |
|  正常流程  | 1.销售人员新建一个销售出货单<br>2.系统显示一个新销售出货单，包括：单据编号，客户，业务员，操作员，仓库，出货商品清单，折让前总额，折让，使用代金卷金额，折让后总额，备注。出货商品清单中要显示商品的编号，名称，型号，数量，单价，金额，商品备注。<br>3.系统自动计算除名称、数量、备注、折让等的其余部分并显示<br>4.销售人员手动输入入库商品列表中的名称、数量、备注等信息<br>5.系统重新计算并显示销售出货单<br>6.重复4~5步直至销售人员完成销售出货单<br>7.系统生成最终的销售出货单并显示 |
|  扩展流程  | 4a.销售人员更改单价、业务员等默认选项<br>1.系统更改销售单中的单价等默认选项并显示<br>4b.销售人员设置折让<br>1.系统查询系统使用者的权限，设置折让限额<br>2.销售人员输入折让<br>3.系统查询折让是否在限额内，若是则显示折让价格并重新计算金额，显示销售单<br>4c.数量格式错误<br>1.系统提示数量格式错误 |
|  特殊需求  | 1.单据编号的格式：XSD-yyyyMMdd-xxxxx，后五位每天从1开始编号，所以一天最多可以生成99999条单子<br>2.客户：仅显示销售商<br>3.业务员：和这个客户打交道的公司员工，可以设置一个客户的默认业务员<br>4.操作员：当前登录系统的用户<br>5.销售人员分为销售员和销售经理。销售员最多折让1000元，销售经理可以折让5000元，总经理可以任意金额的折让。<br>6.名称：从商品选择界面选择<br>7.单价：默认为商品信息里的销售价，可修改<br>8.销售出货单通过审批后，会更改库存数据和客户的应收应付数据<br>9.操作简单容易上手 |

### 用例13

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 13                                       |
|  创建者   | 高梦婷                                      |
|   时间   | 2017.9.11                                |
|   名称   | 制定销售退货单                                  |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 销售人员，目标是及时有效的完成销售退货                      |
|  触发条件  | 已经销售出货的商品出现问题需要退货                        |
|  前置条件  | 销售人员必须已经被识别或授权                           |
|  后置条件  | 生成一个销售退货单，等待审核                           |
|  优先级   | 高                                        |
|  正常流程  | 1.销售人员新建一个销售退货单<br>2.系统显示一个新销售退货单，包括：单据编号，客户，业务员，操作员，仓库，出货商品清单，折让前总额，折让，使用代金卷金额，折让后总额，备注。出货商品清单中要显示商品的编号，名称，型号，数量，单价，金额，商品备注<br>3.系统自动计算除名称、数量、备注、折让等的其余部分<br>4.销售人员手动输入、选择、添加入库商品列表中的名称、数量、备注等信息<br>5.系统重新计算并生成显示销售退货单<br>6.重复4~5步直至销售人员完成销售退货单<br>7.系统生成最终销售退货单并显示 |
|  扩展流程  | 4a.销售人员更改单价、业务员等默认选项<br>1.系统更改销售退货单中的单价等默认选项并显示<br>4b.销售人员设置折让<br>1.系统查询系统使用者的权限，设置折让限额<br>2.销售人员输入折让<br>3.系统查询折让是否在限额内，若是则显示折让价格并重新计算金额，显示销售退货单<br>4c.数量格式错误<br>1.系统提示数量格式错误 |
|  特殊需求  | 1.单据编号的格式：XSTHD-yyyyMMdd-xxxxx，后五位每天从1开始编号，所以一天最多可以生成99999条单子<br>2.客户：仅显示销售商<br>3.业务员：和这个客户打交道的公司员工，可以设置一个客户的默认业务员<br>4.操作员：当前登录系统的用户<br>5.销售人员分为销售员和销售经理。销售员最多折让1000元，销售经理可以折让5000元，总经理可以任意金额的折让<br>6.名称：从商品选择界面选择<br>7.单价：默认为商品信息里的销售价，可修改<br>8.销售退货单通过审批后，会更改库存数据和客户的应收应付数据<br>9.操作简单容易上手 |



### 用例14

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 14                                       |
|  创建者   | 廖均达                                      |
|   时间   | 2017.9.12                                |
|   名称   | 账户管理                                     |
| 最后更新者  | 廖均达                                      |
| 最后更新日期 | 2017.9.16                                |
|  参与者   | 财务人员，目的是查看账户以及对账户进行增删查改等操作               |
|  触发条件  | 财务人员希望查看账户信息或对其进行管理时                     |
|  前置条件  | 财务人员必须已被识别和授予最高权限                        |
|  后置条件  | 系统记录财务人员操作结果                             |
|  优先级   | 中                                        |
|  正常流程  | 1.系统显示账户列表<br>2.财务人员选择账户或输入账户信息（可进行模糊查找）或直接选择增加账户<br>3.系统根据财务人员的操作显示相关账户<br>4.财务人员对选择的账户进行删除、查询、修改操作<br>5.根据财务人员操作修改账户列表，更新账户信息并显示操作结果 |
|  扩展流程  | 2a. 增加与已存在账户同名账户<br>    1.系统提示错误并要求用户重新输入<br>    2. 返回正常流程5<br>2b.查询的账户不存在<br>    1.系统提示错误<br>    2.返回正常流程 |
|  特殊需求  | 余额不可被修改                                  |

### 用例15

|   条目   | 内容                                       |
| :----: | ---------------------------------------- |
|   ID   | 15                                       |
|  创建者   | 廖均达                                      |
|   时间   | 2017.9.12                                |
|   名称   | 制定收付款单                                   |
| 最后更新者  | 廖均达                                      |
| 最后更新日期 | 2017.9.26                                |
|  参与者   | 财务人员，目的是简单快速的进行收付款操作                     |
|  触发条件  | 财务人员进行收付款操作时                             |
|  前置条件  | 财务人员必须已被识别                               |
|  后置条件  | 根据审批结果更改客户应付（收）数据                        |
|  优先级   | 高                                        |
|  正常流程  | 1 系统生成并显示收（付）款单，收（付）款单的信息包括单据编号，客户（同时包含供应商和销售商），操作员（当前登录用户），转账列表，总额汇总。转账列表中的一项包含：银行账户，转账金额，备注。<br> 2 财务人员对收（付）款单进行填写并进行提交，需要填写的部分为客户，转账列表和总额汇总<br> 3 系统将收（付）款单递交给审批程序，审批通过后入账 |
|  扩展流程  | 2a. 表格填写不完全<br>    1.系统提示出错<br>    2.返回正常流程2<br>2b.填写付款单所选择的账户余额不足<br>    1.系统提示余额不足，要求选择其他账户<br>3a.单据审批通过<br>     1.系统更改客户的应付（收）数据<br>    2.系统给财务人员发送审批通过消息<br>3b.收款单审批未通过<br>    1.系统将未通过消息发送给财务人员 |
|  特殊需求  | 单据编号需遵循格式(SKD-yyyyMMdd-xxxx)             |

### 用例16

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 16                                       |
|  创建者   | 廖均达                                      |
|   时间   | 2017.9.12                                |
|   名称   | 制定现金费用单                                  |
| 最后更新者  | 廖均达                                      |
| 最后更新日期 | 2017.9.21                                |
|  参与者   | 财务人员，目的是简单快速的进行制定现金费用单操作                 |
|  触发条件  | 财务人员进行制定现金费用单操作时                         |
|  前置条件  | 财务人员必须已被识别                               |
|  后置条件  | 减少相应账户余额                                 |
|  优先级   | 中                                        |
|  正常流程  | 1.系统生成并显示现金费用单，单据的信息包括单据编号，操作员（当前登录用户），银行账户，条目清单，总额。条目清单中包括：条目名，金额，备注。<br> 2.财务人员对现金费用单进行填写并进行提交，需要填写的部分为银行账户，条目清单及总额。<br>3. 系统将此单据交给审批程序进行审批 |
|  扩展流程  | 2a. 表格填写不完全<br>    1.系统提示错误<br>    2.返回正常流程2<br>2b.所填账户余额不足<br>  1.系统提示财务人员余额不足<br>    2.返回正常流程2 <br>3a.单据通过审批<br>    1.系统给财务人员发送审批通过消息 <br>    系统将此单据入账<br>3b.单据未通过审批<br>    1.系统给财务人员发送审批未通过消息 |
|  特殊需求  | 单据编号需遵循格式(XJFYD-yyyyMMdd-xxxxx)          |

### 用例17

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 17                                       |
|  创建者   | 廖均达                                      |
|   时间   | 2017.9.12                                |
|   名称   | 期初建账                                     |
| 最后更新者  | 廖均达                                      |
| 最后更新日期 | 2017.9.26                                |
|  参与者   | 财务人员，目的是简单快速的进行期初建账操作，并能随时查看期初建账信息       |
|  触发条件  | 财务人员进行期初建账                               |
|  前置条件  | 财务人员必须已被识别                               |
|  后置条件  | 将该期初建账信息单独存储                             |
|  优先级   | 高                                        |
|  正常流程  | 1.系统生成期初建账的表格，表格的内容包括：添加商品信息（商品分类，某一商品的名称，类别，型号，进价/售价(默认为上年平均)，最近进价和最近售价留空），客户信息（客户分类，某一个客户的名称，联系方式等，应收应付(之前遗留)），银行账户信息（名称，余额）<br>2.财务人员填写表格并提交<br>3.系统显示建账结果 |
|  扩展流程  | 2a.表格填写不完全<br>    1.系统提示错误<br>    2.返回正常流程2 |
|  特殊需求  | 1.期初建账完毕后任何操作不会改变其信息，且必须随时可查 <br>2.期初建账信息需要单独存储 |

### 用例18

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 18                                       |
|  创建者   | 陈俊宇                                      |
|   时间   | 2017.9.11                                |
|   名称   | 审批单据                                     |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 总经理，目的是确保所有单据正确从而确保其他系统人员工作能正常进行         |
|  触发条件  | 总经理对申请数据进行查看                             |
|  前置条件  | 总经理必须已被识别和授权，所有申请数据都处于提交状态               |
|  后置条件  | 系统保存最新的单据状态信息                            |
|  优先级   | 高                                        |
|  正常流程  | 1. 系统显示所有处于提交状态的单据<br> 2. 总经理选择某一单据进行查看<br> 3. 总经理对有问题的单据作出修改<br> 4. 总经理通过带单据的审批<br>5. 系统将该单据状态设置为已审批并向相关人员发送信息<br> 6. 重复2-5直至所有申请单据被被处理完成 |
|  扩展流程  | 2a. 总经理选择批量审批<br><t>1. 总经理可以自由选择每次同时要查阅的单据 |
|  特殊需求  | 可批量审阅                                    |

### 用例19

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 19                                       |
|  创建者   | 陈俊宇                                      |
|   时间   | 2017.9.11                                |
|   名称   | 查看销售明细表                                  |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 财务人员，总经理 目的是统计一段时间内商品的销售情况               |
|  触发条件  | 财务人员和总经理查询销售出货单据时                        |
|  前置条件  | 财务人员和总经理必须已经被识别和授权                       |
|  后置条件  | 无                                        |
|  优先级   | 中等                                       |
|  正常流程  | 1 总经理或财务人员选择筛选条件（时间区间、商品名、客户、仓库、业务员）<br> 2 系统以列表形式显示符合条件的商品销售记录，信息包括时间、商品名、型号、数量、单价、总额 |
|  扩展流程  | 2a. 需要导出数据<br>1. 系统根据用户所选的目录生成excel文件    |
|  特殊需求  | 可导出数据                                    |

### 用例20

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 20                                       |
|  创建者   | 陈俊宇                                      |
|   时间   | 2017.9.11                                |
|   名称   | 查看经营历程表                                  |
| 最后更新者  | 廖均达                                      |
| 最后更新日期 | 2017.9.22                                |
|  参与者   | 总经理及财务人员，目的是查看与管理一段时间里的所有单据              |
|  触发条件  | 总经理或财务人员查看经营历程表时                         |
|  前置条件  | 总经理或财务人员必须已经被识别和授权                       |
|  后置条件  | 无                                        |
|  优先级   | 中                                        |
|  正常流程  | 1 总经理选择筛选条件（时间区间、单据类型、客户、业务员、仓库）<br>2 系统显示符合条件的所有单据 |
|  扩展流程  | 2a. 需要导出数据<br>1. 系统根据用户所选的目录生成excel文件 <br>2b.财务人员请求进行红冲操作<br>    1.系统进行红冲操作并显示操作结果<br>2c.财务人员请求进行红冲并复制操作<br>    1.系统生成红冲草稿单（与之前单子一模一样但是仅仅把数量取负数的单子，模板也与之前单子相同）<br>    2.财务人员进行编辑后提交<br>    3.系统进行红冲操作并显示操作结果 |
|  特殊需求  | 可导出数据                                    |

### 用例21

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 21                                       |
|  创建者   | 陈俊宇                                      |
|   时间   | 2017.9.11                                |
|   名称   | 查看经营情况表                                  |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 总经理、财务人员，目的是显示一段时间内的经营收支情况和利润            |
|  触发条件  | 总经理、财务人员的身份必须已经被识别和授权                    |
|  前置条件  | 当前登录账号为库存管理人员账号，身份已验证无误。                 |
|  后置条件  | 无                                        |
|  优先级   | 中                                        |
|  正常流程  | 1 总经理或财务人员填写要查询的时间区间<br>2 系统显示信息（收入类、支出类、利润） |
|  扩展流程  | 2a. 需要导出数据<br>1. 系统根据用户所选的目录生成excel文件    |
|  特殊需求  | 1 可导出数据<br> 2 收入类显示折让后总收入<br>3 支出类显示总支出  |

### 用例22

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 22                                       |
|  创建者   | 陈俊宇                                      |
|   时间   | 2017.9.12                                |
|   名称   | 制定促销策略                                   |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 总经理，目的是吸引顾客，为公司创造收益                      |
|  触发条件  | 总经理制定策略时                                 |
|  前置条件  | 总经理的身份必须已经被识别和授权                         |
|  后置条件  | 系统更新已有的促销策略                              |
|  优先级   | 中                                        |
|  正常流程  | 1 总经理制定赠送单<br>2 总经理制定赠送单所对应的赠品条件<br>3 系统生成促销方案 |
|  扩展流程  | 无                                        |
|  特殊需求  | 1 总经理可以针对不同级别的用户制定促销策略<br>2 总经理可以制定特价包<br>3 总经理可以制定对不同总价的促销策略<br>4 所有促销策略都有起始时间和时间间隔<br>5 对于一笔订单最终只有一款促销策略生效<br>6 赠品促销条件触发后，系统自动建立库存赠送单，经总经理审批通过后，发送消息给库存管理员发送赠品 |

### 用例23

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 23                                       |
|  创建者   | 陈俊宇                                      |
|   时间   | 2017.9.21                                |
|   名称   | 查询日志                                     |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 总经理、财务人员，目的是查看系统的主要操作，确保公司正常进行           |
|  触发条件  | 总经理、财务人员查询时                              |
|  前置条件  | 总经理、财务人员的身份必须已经被识别和授权                    |
|  后置条件  | 无                                        |
|  优先级   | 中                                        |
|  正常流程  | 1 总经理、财务人员请求查询日志<br>2 系统显示日志列表<br>3 总经理，财务人员选择某一具体日志查看<br>4 系统显示日志详情 |
|  扩展流程  | 无                                        |
|  特殊需求  | 无                                        |

### 用例24

|   条目   | 内容                                       |
| :----: | :--------------------------------------- |
|   ID   | 24                                       |
|  创建者   | 廖均达                                      |
|   时间   | 2017.9.12                                |
|   名称   | 管理系统用户信息                                 |
| 最后更新者  |                                          |
| 最后更新日期 |                                          |
|  参与者   | 管理员，目的是对用户账户的信息和权限进行管理                   |
|  触发条件  | 管理员对用户进行管理                               |
|  前置条件  | 管理员身份已经被识别                               |
|  后置条件  | 记录管理员操作结果                                |
|  优先级   | 低                                        |
|  正常流程  | 1.系统显示用户账户列表<br> 2.管理员选择用户进行管理<br>3.系统显示操作结果 |
|  扩展流程  | 2a.管理员对管理员账号进行管理<br>    1.系统显示管理员账号信息<br>    2.管理员对信息进行查看、修改等操作<br>    3.返回正常流程2 |
|  特殊需求  | 管理员账号初始账号和密码均为admin                      |
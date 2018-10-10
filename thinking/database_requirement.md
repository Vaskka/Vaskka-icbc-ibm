# 数据库操作需求
> 保证 user_id, order_id, entry_id 全局唯一

### 用户账户操作

#### + 尝试注册 消费者账户/商户账户
##### 具体需求
接受前端上传的参数，将数据插入system_temporary_user（消费者）或system_temporary_commercial（商户）表

#### + 确认注册 消费者账户/商户账户
##### 具体需求
接受上传参数， 对比用户的验证码的正确性，完成后删除相应验证码表中记录和system_temporary_commercial / system_temporary_user表中记录插入到对应system_registered_commercial / system_registered_user表中

#### + 用户登陆
##### 具体需求
接受上传参数，在session表查询登陆信息，已经登陆返回相应token，未登录在session表插入相应的记录，并返回token给前端

#### + 退出登陆
##### 具体需求
接受上传参数，验证登陆状态，在session中删除对应记录

### 拼单操作

#### + 发起拼单
##### 具体需求
接受上传参数，验证登陆状态，向order_commercial_is_waiting表插入对应信息，并关联对应关联表order_commercial__user（记录订单号和参与拼单的用户的映射）

##### + 加入拼单
###### 具体需求
接受上传参数，验证登陆状态，向关联表order_commercial__user插入对应用户信息

##### + 取消拼单
###### 具体需求
接受上传参数，验证登陆状态，向关联表order_commercial__user删除对应用户信息，若是最后一个人取消就将在order_commercial_is_waiting中删除对应记录，插到order_commercial_canceled中

##### + 完成拼单
###### 具体需求
接受上传参数，验证登陆状态，在order_commercial_is_waiting中删除对应记录，插到order_commercial_already_complete中

##### + 某个 (用户/商户) (创建/删除/更新) 某个 (商品/对司机要求/对租房的要求)
###### 具体要求
接受上传参数，验证登陆状态，在相应实体表中插入/删除/更新记录（order_entry_*）

##### + 发起拼车
###### 具体需求
接受上传参数，验证登陆状态，向order_car_is_waiting表插入对应信息，并关联对应关联表order_car__user（记录订单号和参与拼车的用户的映射）

##### + 加入拼车
###### 具体需求
接受上传参数，验证登陆状态，插入记录到order_car_is_waiting表，向关联表order_car__user插入对应用户信息

##### + 完成拼车（司机接到乘客）
###### 具体需求
接受上传参数，验证登陆状态，删除order_car_is_waiting中对应记录，插入到order_car_is_driving中

##### + 结束拼车
###### 具体需求
接受上传参数，验证登陆状态，删除order_car_is_driving中对应记录，插入到order_car_already_complete中

##### + 取消拼车
###### 具体需求
接受上传参数，验证登陆状态，删除order_car_is_driving中对应记录

##### + 发起拼租
###### 具体需求
接受上传参数，验证登陆状态，插入记录到order_house_is_waiting表

##### + 完成拼租
###### 具体需求
接受上传参数，验证登陆状态，在order_house_is_waiting表中删除记录，插入到order_house_already_complete中

##### + 取消拼租
###### 具体需求
接受上传参数，验证登陆状态，在order_house_is_waiting中直接删除记录，插入到order_house_canceled表中


##### + 获得用户信息
##### + 获得某订单信息
##### + 获得某商户创建的全部商品
##### + 获得某用户创建的拼车要求
##### + 获得某用户创建的拼租要求
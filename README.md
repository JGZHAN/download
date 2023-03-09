# down
* 使用多线程下载网络文件;
* 使用RandomAccessFile在指定文件位置开始写入;
* 支持断点续传（暂停或这被迫中断后继续下载）
* 使用connection.setRequestProperty("Range", "bytes=" + from + "-" + to)将网络文件分块读取;
# Getting Started

### 依赖MAVEN Lombok、fastjson2

打包成为jar包，
进入到jar包的目录下，直接使用java -jar命令:
* java -jar down.jar 下载目标的地址 [可选-下载到的目标文件夹]


 # 使用Linux
### 可以使用Linux定义你的命令
* 使用使用命令 'vi /etc/profile',然后想下图所示一样，在文件的末尾添加定义，其中红框内的是打包好的jar包所在的文件地址；

<img width="728" alt="image" src="https://user-images.githubusercontent.com/62022681/222921531-834640b5-0253-4228-82ee-0505342753eb.png">


* 然后使用命令'down 需要下载的文件地址'下载文件，这里以下载微信安装包为例，可以不指定第二个参数（下载后的文件路径），默认放在当前使用命令的文件夹；

<img width="705" alt="image" src="https://user-images.githubusercontent.com/62022681/222921813-1e096f32-8589-41a0-a198-43332da1f714.png">


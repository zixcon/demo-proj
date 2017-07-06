## 1. 本地：
#### 1.1 创建本地git项目目录
mkdir git-learning
cd git-learning
git init
#### 1.2 创建密钥
ssh-keygen -t rsa -C "your_email@youremail.com"
 这个地方请注意，它会在你选择的路径下上生成 ssh key，如果你直接点击回车，会在默认路径下创建 ssh 。如果你有多个项目，有工作的，有自己玩的，那么请配置不同的路径，或者一个路径换个文件名
 直接回车不设置密码

pbcopy < ~/.ssh/id_xxxx_rsa.pub
 作用是将你的 ssh 代码复制到剪贴板。
## 2. github
#### 2.1 创建git项目目录
#### 2.2 设置密钥并验证
ssh -T git@github.com
 permission denied,你就再执行命令：ssh-add ~/.ssh/id_xxxx_rsa
## 3.本地
#### 3.1 设置账户
git config --global user.name "your name"
git config --global user.email "your_email@youremail.com"
## 4. 上传测试
#### 4.1 测试
touch test.txt
git add test.txt
git commit -m "更新测试"

git remote add origin git@github.com:用户名/项目名.git 
git push orgin master
## 5. 问题解决
#### 5.1 error: failed to push some refs to 'git@github.com:zixcon/demo-proj.git'
原因： 
GitHub远程仓库中的README.md文件不在本地仓库中。 
解决方案：
$ git pull --rebase origin master
$ git push -u origin master

## 其他问题
#### 使用一段时间后，或者电脑重启后没有权限
问题：Permission denied (publickey). fatal: Could not read from remote repository
> ssh-add ~/.ssh/id_rsa
> #and, to confirm it's been added to the known list of keys
> ssh-add -l

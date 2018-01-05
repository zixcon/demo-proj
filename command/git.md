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

## 6. merge合并
    git checkout targetBranch  //切换回targetBranch
    git merge --no-ff sourceBranch  //把sourceBranch的修改merge到targetBranch。注意：建议merge的时候总是用 --no-ff 选项
    –no-ff 可以保存你之前的分支历史。能够更好的查看 merge历史,以及branch 状态。


## 其他问题
#### 使用一段时间后，或者电脑重启后没有权限
问题：Permission denied (publickey). fatal: Could not read from remote repository
> ssh-add ~/.ssh/id_rsa
> #and, to confirm it's been added to the known list of keys
> ssh-add -l
#### merge问题 【You have not concluded your merge (MERGE_HEAD exists)】
1. 保留你本地的修改
git merge --abort
git reset --merge
合并后记得一定要提交这个本地的合并
然后在获取线上仓库
git pull

2. down下线上代码版本,抛弃本地的修改
不建议这样做,但是如果你本地修改不大,或者自己有一份备份留存,可以直接用线上最新版本覆盖到本地
git fetch --all
git reset --hard origin/master
git fetch
3. 重新clone

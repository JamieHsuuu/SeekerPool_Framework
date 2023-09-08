# Seeker's Pool - Spring Boot 版本 (陸續修改中)
## 專題介紹
簡易的人力銀行求職網站，提供一般會員進行求職、企業會員尋找人才。
## 使用技術
- 前端：HTML, CSS, JavaScript, JQuery, Bootstrap, Axios  
- 後端：MVC架構 (RESTful Controller + Service + Repository), Spring Boot, Spring MVC, Spring Data JPA  
- 資料庫：MySQL, Redis（使用於註冊帳號時須填寫的驗證碼）
## 功能說明
**【企業前台】**
1. 企業會員註冊 - 驗證碼存在 Redis 中並寄出信件
2. 企業會員登入、登出 - 使用 HttpFilter 確認是否登入
3. 企業會員資料管理 - 修改基本資料及大頭照
4. 應徵者管理 - 可透過選單過濾應徵者目前面試狀況、邀請面試時帶入企業上架中職缺
5. 取消面試
6. 完成面試

**【一般前台】**
- 瀏覽企業資訊 - 瀏覽企業的公開資訊及上架中的職缺

**【後台】**  
- 企業會員管理 - 可查詢企業會員資訊並修改帳號狀態

## 補充連結
- [影片展示](https://www.youtube.com/watch?v=FMN8VVAX7E8&t=1260s&ab_channel=%E7%B7%AF%E8%82%B2TibaMe) （23:30 開始）

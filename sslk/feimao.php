<?php
/*
 SQL
CREATE TABLE `notifacation`(
		`id` int PRIMARY KEY AUTO_INCREMENT ,
		`mse`  varchar(32) not null
		)charset utf8;

CREATE TABLE `user`(
		`id` int PRIMARY KEY AUTO_INCREMENT ,
		`username`  varchar(32) not null  ,
		`passwd` varchar(32) not null ,
		`data` date DEFAULT '20170701'
		)charset utf8;

CREATE TABLE `jihuoma`(
    `id` int PRIMARY KEY AUTO_INCREMENT ,
    `haoma` char(32) not null unique ,
    `shiyong` tinyint DEFAULT 0,
	`tianshu` int DEFAULT 30,
	`useid` int
)charset utf8;
*/
header("Content-Type: text/html; charset=UTF-8");
date_default_timezone_set('PRC');
class Help {

	private $username = "zjwdb_6070477";
	private $password = "594262005zzQ";
	private $url = "localhost";
	private $db_connect = "zjwdb_6070477";
	private $pdo = null;

	function Help(){
		$this->pdo = new PDO( "mysql:host=" . $this->url . ";dbname=".$this->db_connect 
				, $this->username , $this->password);
		//设置出错方式为异常模式
		$this->pdo->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION); 
		$this->pdo->query('set names utf8');
	}

	public function getNoti(){
		$sql = "SELECT id , mse FROM notifacation ORDER BY ID DESC LIMIT 0,10";
		$res = $this->pdo->query($sql);

		while( ($glsz = $res -> fetch(PDO::FETCH_ASSOC) )){

			echo $glsz["mse"].',';
		}
	}
	
	public function reg($name,$passwd,$date){
		$sql = 'INSERT INTO `user` VALUES(null ,? , ?, ? )';
		$stat = $this->pdo -> prepare($sql);
		$stat->bindParam(1,$name);
		$stat->bindParam(2,$passwd);
		$stat->bindParam(3,$date);
		$res = $stat -> execute();
		if ($res) {
			echo 'y';	
		}else{
			echo 'n';
		}
	}

	//最好返回其所时间
	public function login($name,$passwd){
			$sql = 'SELECT passwd,`data` FROM user WHERE username = ?';
			$stat = $this->pdo -> prepare($sql);
			$stat->bindParam(1,$name);
			$res = $stat -> execute();
			if ($res) {
				$arr = $stat -> fetch(PDO::FETCH_ASSOC);
				
				if ($arr['passwd'] == $passwd){
					echo $arr['data'];
				}else{
					echo 'n';
				}
				
			}else{
				echo 'n';
			}
	}

	//充值激活码的功能
	public function jihuoma($name,$jihuoma){
		//先判断激活码是否存在
			$sql = 'SELECT shiyong,tianshu,useid FROM jihuoma WHERE haoma = ?';
		//
			$stat = $this->pdo -> prepare($sql);
			$stat->bindParam(1,$jihuoma);
			$res = $stat -> execute();
			if ($res) {
				$arr = $stat -> fetch(PDO::FETCH_ASSOC);
				if ($arr) {
					if( $arr['shiyong'] == "1" ){
						echo '激活码已被使用....';
					}else{
						$ts = $arr['tianshu'];
						$sql = 'SELECT id,data FROM user WHERE username = ? ';
						//开启事务
						$this->pdo->beginTransaction(); 
						try{
							$stat1 =  $this->pdo -> prepare($sql);
							$stat1 -> bindParam (1,$name);
							$stat1 -> execute();
							
							$usearr = $stat1 -> fetch(PDO::FETCH_ASSOC);
							if ($arr) {
								$useid = $usearr['id'];

								//算出用户需要加的日期到几号
								//当前日期
								$current_date = intval(date("Ymd" , time()));
								$taget_data = intval(date("Ymd" ,strtotime($usearr['data'])));
								if( $current_date < $taget_data ){
									$dataadd = new  DateTime($taget_data);
								}else{
									$dataadd = new  DateTime($current_date);
								}
								$useData = $dataadd ->add ( new DateInterval( 'P'.$ts.'D' ) );
								$useData = $useData->format('Ymd');
								$this->pdo->query('UPDATE jihuoma SET shiyong=1,useid='. $useid . ' WHERE haoma="' . $jihuoma . '"');
								$this->pdo->query('UPDATE user SET data="' . $useData . '"  WHERE id = ' . $useid );
								$this->pdo->commit();
							echo '用户充值成功，哦耶!!';
						}else{
							echo '用户不存在，请检查当前用户状态';
						}
					}catch(Exception $e){
						echo '提交失败，请重试';
						$this->pdo->rollBack();
						echo $e->getMessage(); //获取异常信息
					}
					}
				}else{
					echo '激活码不存在....';
				}
				
			}else{
				echo '执行失败';
			}
	}

	//修改密码

	public function gaimima($user , $old_passwd , $new_passwd){
			$sql = 'SELECT passwd FROM user WHERE username = ?';
			$stat = $this->pdo -> prepare($sql);
			$stat->bindParam(1,$user);
			$res = $stat -> execute();
			if ($res) {
				$arr = $stat -> fetch(PDO::FETCH_ASSOC);
				
				if ($arr['passwd'] == $old_passwd){
					//密码正确后更改密码
					$sql = 'UPDATE user SET passwd = ? WHERE username = ? ';
					$stat = $this->pdo -> prepare($sql);
					$stat->bindParam(1,$new_passwd);
					$stat->bindParam(2,$user);
					$res = $stat -> execute();
					if ($res ) {
						echo 'y';
					}else{
						echo 'n';
					}					
				}else{
					echo 'n';
				}
				
			}else{
				echo 'n';
			}
	}

}


if (isset($_GET['s']) && $_GET['s'] == "noti"){
	$help = new Help();
	$help -> getNoti();
}else if(isset($_POST['s']) && $_POST['s'] == "reg" ){
	$help = new Help();
	$name = $_POST['name'] ;
	$passwd = $_POST['passwd'] ;
	$date  = date( "Ymd",time()-86400);
	$help -> reg($name,$passwd,$date);
}else if(isset($_POST['s']) && $_POST['s'] == "login" ){
	$help = new Help();
	$name = $_POST['name'] ;
	$passwd = $_POST['passwd'] ;
	$help -> login($name,$passwd);
}else if (isset($_GET['s']) && $_GET['s'] == "jihuoma"){
	$help = new Help();
	$name = $_GET['name'] ;
	$jihuoma =  $_GET['jihuoma'] ;
	$help -> jihuoma($name,$jihuoma);
}else if (isset($_POST['s']) && $_POST['s'] == "gaimima"){
	$help = new Help();
	$name = $_POST['name'] ;
	$old_passwd =  $_POST['passwd'] ;
	$new_passwd =  $_POST['new_passwd'] ;
	$help -> gaimima($name,$old_passwd,$new_passwd ) ; 
}else{
	echo '接口参数有误，请不要随便输入!!';
}

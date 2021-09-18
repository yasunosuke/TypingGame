import java.util.Scanner;

/**
 *ログインするためのメソッドを持つクラス
 *
 */
public class LogIn {
	private Scanner sc;
	private PlayerRecords playerRecords;
	
	public LogIn(Scanner sc, PlayerRecords playerRecords) {
		super();
		this.sc = sc;
		this.playerRecords = playerRecords;
	}
	
	/**
	 * 名前が登録済みならPlayerクラスのインスタンスを返す。
	 * 名前が登録済みでないなら新しく登録してPlayerクラスのインスタンスを返す。
	 * @return
	 */
	public Player login() {

		if(askIsRegistered(sc)) {
			return signIn();
		} else {
			return registerNewName();
		}
		
	}
	
	/**
	 * 名前を登録済みかどうかを尋ねるメソッド。
	 * 登録済みの場合(入力値１)はtrueを
	 * 登録済みでない場合（入力値０）はfalseを返す。
	 * @param sc
	 * @return
	 */
	private boolean askIsRegistered(Scanner sc) {

		while (true) {
			System.out.println("あなたは登録者ですか？「登録者・・・１，登録者ではない・・・０」");
			try {
				int input = Integer.parseInt(sc.nextLine());
				if (0 <= input && input <= 1) {
					if (input == 1) {
						return true;
					} else {
						return false;
					}
				} else {
					System.out.println("不正な値が入力されました。もう一度入力して下さい。");
				}

			} catch (NumberFormatException e) {
				System.out.println("不正な値が入力されました。もう一度入力して下さい。");
			}
		}
		
	}
	
	/**
	 * 登録済みの場合、名前(入力)を受け取りPlayerクラスのインスタンスを返す。そしてログインした旨を表示する。
	 * 登録済みの名前と一致するまで繰り返す。
	 * 名前のフォーマットはアルファベット大文字、小文字。１文字以上５文字以下
	 * PlayRecordsのgetPlayerRecordsでPlayerクラスのインスタンを初期化する。
	 * @return
	 */
	private Player signIn() {
		
		Player player = null;
		
		while(true) {
			System.out.println("名前を入力して下さい。(アルファベット大文字、小文字)");
			String name = sc.nextLine();
			
			if(matchName(name)) {
				
				if(playerRecords.confirmIsRegisteredName(name)) {
					player = playerRecords.getPlayerRecords(name);
					System.out.println("ログインしました。");
					break;
				} else {
					System.out.println("その名前は存在しません。もう一度入力して下さい。");
				}
				
			} else {
				System.out.println("正しい名前を入力して下さい.（アルファベット大文字、小文字。１文字以上５文字以下）");
			}
			
			
		}
		
		return player;
	}
	
	/**
	 * 新たな名前を登録するためのメソッド。
	 * 入力値（アルファベット大文字、小文字。１文字以上５文字以下）を受け取りPlayerRecordsのに登録する.
	 * 登録がPlayerクラスのインスタンスを受け取り、ログインした旨を表示する。
	 * 既に使われている名前ではない場合かつ名前のフォーマットに合致するまで繰り返す。
	 * @return
	 */
	private Player registerNewName() {
		
		Player player = null;
		
		while(true) {
			System.out.println("登録する名前を入力して下さい。(アルファベット大文字、小文字。１文字以上５文字以下。)");
			String name = sc.nextLine();
			
			if(matchName(name)) {
				
				if(playerRecords.confirmIsRegisteredName(name)) {
					System.out.println("名前が既に使われています。もう一度入力して下さい。");
				} else {
					playerRecords.registerName(name);
					System.out.println("名前を登録しました。");
					player = playerRecords.getPlayerRecords(name);
					System.out.println("ログインしました。");
					break;
				}
				
			} else {
				System.out.println("正しい名前を入力して下さい.（アルファベット大文字、小文字。１文字以上５文字以下）");
			}
		}
		
		return player;
	}
	
	/**
	 * 名前がフォーマットに合致するかどうかを調べるメソッド。
	 * 合致した場合はtrue、
	 * 合致しない場合はfalseを返す。
	 * @param name
	 * @return
	 */
	private boolean matchName(String name) {
		return name.matches("[a-zA-Z]{1,5}");
	}
	
	
}

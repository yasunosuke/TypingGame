import java.util.Scanner;

/**
 *���O�C�����邽�߂̃��\�b�h�����N���X
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
	 * ���O���o�^�ς݂Ȃ�Player�N���X�̃C���X�^���X��Ԃ��B
	 * ���O���o�^�ς݂łȂ��Ȃ�V�����o�^����Player�N���X�̃C���X�^���X��Ԃ��B
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
	 * ���O��o�^�ς݂��ǂ�����q�˂郁�\�b�h�B
	 * �o�^�ς݂̏ꍇ(���͒l�P)��true��
	 * �o�^�ς݂łȂ��ꍇ�i���͒l�O�j��false��Ԃ��B
	 * @param sc
	 * @return
	 */
	private boolean askIsRegistered(Scanner sc) {

		while (true) {
			System.out.println("���Ȃ��͓o�^�҂ł����H�u�o�^�ҁE�E�E�P�C�o�^�҂ł͂Ȃ��E�E�E�O�v");
			try {
				int input = Integer.parseInt(sc.nextLine());
				if (0 <= input && input <= 1) {
					if (input == 1) {
						return true;
					} else {
						return false;
					}
				} else {
					System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
				}

			} catch (NumberFormatException e) {
				System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
			}
		}
		
	}
	
	/**
	 * �o�^�ς݂̏ꍇ�A���O(����)���󂯎��Player�N���X�̃C���X�^���X��Ԃ��B�����ă��O�C�������|��\������B
	 * �o�^�ς݂̖��O�ƈ�v����܂ŌJ��Ԃ��B
	 * ���O�̃t�H�[�}�b�g�̓A���t�@�x�b�g�啶���A�������B�P�����ȏ�T�����ȉ�
	 * PlayRecords��getPlayerRecords��Player�N���X�̃C���X�^��������������B
	 * @return
	 */
	private Player signIn() {
		
		Player player = null;
		
		while(true) {
			System.out.println("���O����͂��ĉ������B(�A���t�@�x�b�g�啶���A������)");
			String name = sc.nextLine();
			
			if(matchName(name)) {
				
				if(playerRecords.confirmIsRegisteredName(name)) {
					player = playerRecords.getPlayerRecords(name);
					System.out.println("���O�C�����܂����B");
					break;
				} else {
					System.out.println("���̖��O�͑��݂��܂���B������x���͂��ĉ������B");
				}
				
			} else {
				System.out.println("���������O����͂��ĉ�����.�i�A���t�@�x�b�g�啶���A�������B�P�����ȏ�T�����ȉ��j");
			}
			
			
		}
		
		return player;
	}
	
	/**
	 * �V���Ȗ��O��o�^���邽�߂̃��\�b�h�B
	 * ���͒l�i�A���t�@�x�b�g�啶���A�������B�P�����ȏ�T�����ȉ��j���󂯎��PlayerRecords�̂ɓo�^����.
	 * �o�^��Player�N���X�̃C���X�^���X���󂯎��A���O�C�������|��\������B
	 * ���Ɏg���Ă��閼�O�ł͂Ȃ��ꍇ�����O�̃t�H�[�}�b�g�ɍ��v����܂ŌJ��Ԃ��B
	 * @return
	 */
	private Player registerNewName() {
		
		Player player = null;
		
		while(true) {
			System.out.println("�o�^���閼�O����͂��ĉ������B(�A���t�@�x�b�g�啶���A�������B�P�����ȏ�T�����ȉ��B)");
			String name = sc.nextLine();
			
			if(matchName(name)) {
				
				if(playerRecords.confirmIsRegisteredName(name)) {
					System.out.println("���O�����Ɏg���Ă��܂��B������x���͂��ĉ������B");
				} else {
					playerRecords.registerName(name);
					System.out.println("���O��o�^���܂����B");
					player = playerRecords.getPlayerRecords(name);
					System.out.println("���O�C�����܂����B");
					break;
				}
				
			} else {
				System.out.println("���������O����͂��ĉ�����.�i�A���t�@�x�b�g�啶���A�������B�P�����ȏ�T�����ȉ��j");
			}
		}
		
		return player;
	}
	
	/**
	 * ���O���t�H�[�}�b�g�ɍ��v���邩�ǂ����𒲂ׂ郁�\�b�h�B
	 * ���v�����ꍇ��true�A
	 * ���v���Ȃ��ꍇ��false��Ԃ��B
	 * @param name
	 * @return
	 */
	private boolean matchName(String name) {
		return name.matches("[a-zA-Z]{1,5}");
	}
	
	
}

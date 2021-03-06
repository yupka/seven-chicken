package khie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class _6_Menu extends JFrame{
	
	DecimalFormat formatter = new DecimalFormat("###,###");
	
	static int result = _2_Log.result;
	static int count = _2_Log.count;
	
	Connection con = null;				// DB와 연결하는 객체
	PreparedStatement pstmt = null;		// SQL문을 DB에 전송하는 객체
	ResultSet rs = null;				// SQL문 실행 결과를 가지고 있는 객체
	String sql = null;					// SQL문을 저장하는 문자열 변수.
	
	int cheesetrufflecount = _2_Log.cheesetrufflecount, friedcount = _2_Log.friedcount, 
		honeycount = _2_Log.honeycount, honeycombocount = _2_Log.honeycombocount, 
		originalcount = _2_Log.originalcount, originalhalfcount = _2_Log.originalhalfcount,
		redcount = _2_Log.redcount, redcombocount = _2_Log.redcombocount, 
		redhoneyhalfcount = _2_Log.redhoneyhalfcount, salsalcount = _2_Log.salsalcount, 
		shinhwacount = _2_Log.shinhwacount, signaturesetcount = _2_Log.signaturesetcount;
	int cheeseballcount = _2_Log.cheeseballcount, chickenburgercount = _2_Log.chickenburgercount, 
		chickenkatzcount = _2_Log.chickenkatzcount, chillypotatocount = _2_Log.chillypotatocount, 
		chipcasabacount = _2_Log.chipcasabacount, gguabegicount = _2_Log.gguabegicount,
		potatowedgescount = _2_Log.potatowedgescount, mucount = _2_Log.mucount, 
		redpicklecount = _2_Log.redpicklecount, saladcount = _2_Log.saladcount, 
		saucehabaneromayocount = _2_Log.saucehabaneromayocount, sauceredcount = _2_Log.sauceredcount, 
		saucehoneygarliccount = _2_Log.saucehoneygarliccount, saucesweetchillycount = _2_Log.saucesweetchillycount,
		saucetartarecount = _2_Log.saucetartarecount;
	int cokecount = _2_Log.cokecount, spritecount = _2_Log.spritecount, fantacount = _2_Log.fantacount, 
		hanlasanbeercount = _2_Log.hanlasanbeercount, honeysparklingcount = _2_Log.honeysparklingcount, 
		draftbeercount = _2_Log.draftbeercount;
	
	static JButton cartBtn;
	
	public _6_Menu() {
		
		setTitle("메뉴 선택");
		
		JTabbedPane tab = new JTabbedPane();
		tab.setBackground(Color.WHITE);
		
		Font font = new Font("함초롬돋움", Font.BOLD, 13);
		tab.setFont(font);
		
	// 컨테이너
		JPanel containerChicken = new JPanel(new GridLayout(4,3,5,5));
		JPanel containerSide = new JPanel(new GridLayout(5,3,5,5));
		JPanel containerDrink = new JPanel(new GridLayout(3,3,5,5));
		
		JPanel southButton = new JPanel();
		
//		containerChicken.setBackground(Color.WHITE);
//		containerSide.setBackground(Color.WHITE);
//		containerDrink.setBackground(Color.WHITE);
		
	// 컴포넌트
	// 치킨 컴포넌트	
		String[] menu = {"<HTML><body><center>세븐치즈트러플<br>19,000원</center></body></HTML>",
					"<HTML><body><center>세븐후라이드<br>17,500원</center></body></HTML>",
					"<HTML><body><center>세븐허니오리지날<br>16,000원</center></body></HTML>",
					"<HTML><body><center>세븐허니콤보<br>20,000원</center></body></HTML>",
					"<HTML><body><center>세븐오리지날<br>16,000원</center></body></HTML>",
					"<HTML><body><center>세븐오리지날반반<br>17,000원</center></body></HTML>",
					"<HTML><body><center>세븐레드오리지날<br>17,000원</center></body></HTML>",
					"<HTML><body><center>세븐레드콤보<br>20,000원</center></body></HTML>",
					"<HTML><body><center>세븐레허반반<br>22,000원</center></body></HTML>",
					"<HTML><body><center>세븐살살치킨<br>17,000원</center></body></HTML>",
					"<HTML><body><center>세븐신화오리지날<br>18,000원</center></body></HTML>",
					"<HTML><body><center>세븐시그니처세트<br>27,500원</center></body></HTML>"};
		
		// 버튼에 이미지를 삽입하기 위해 Icon <-> Image 변환
		
		// 세븐치즈트러플
		ImageIcon cheeseTruffleicon = new ImageIcon("chicken_images/cheesetruffle.png");
		Image cheeseTruffleimg = cheeseTruffleicon.getImage();
		Image changeCheeseTruffleImage = cheeseTruffleimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeCheeseTruffleIcon = new ImageIcon(changeCheeseTruffleImage);
		// 세븐후라이드
		ImageIcon friedicon = new ImageIcon("chicken_images/fried.png");
		Image friedimg = friedicon.getImage();
		Image changeFriedImage = friedimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeFriedIcon = new ImageIcon(changeFriedImage);
		// 세븐허니오리지날
		ImageIcon honeyicon = new ImageIcon("chicken_images/honey.png");
		Image honeyimg = honeyicon.getImage();
		Image changeHoneyImage = honeyimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeHoneyIcon = new ImageIcon(changeHoneyImage);
		// 세븐허니콤보
		ImageIcon honeycomboicon = new ImageIcon("chicken_images/honeycombo.png");
		Image honeycomboimg = honeycomboicon.getImage();
		Image changeHoneycomboImage = honeycomboimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeHoneycomboIcon = new ImageIcon(changeHoneycomboImage);
		// 세븐오리지날
		ImageIcon originalicon = new ImageIcon("chicken_images/original.png");
		Image originalimg = originalicon.getImage();
		Image changeOriginalImage = originalimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeOriginalIcon = new ImageIcon(changeOriginalImage);
		// 세븐오리지날반반
		ImageIcon originalhalficon = new ImageIcon("chicken_images/originalhalf.png");
		Image originalhalfimg = originalhalficon.getImage();
		Image changeOriginalhalfImage = originalhalfimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeOriginalhalfIcon = new ImageIcon(changeOriginalhalfImage);
		// 세븐레드오리지날
		ImageIcon redicon = new ImageIcon("chicken_images/red.png");
		Image redimg = redicon.getImage();
		Image changeRedImage = redimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeRedIcon = new ImageIcon(changeRedImage);
		// 세븐레드콤보
		ImageIcon redcomboicon = new ImageIcon("chicken_images/redcombo.png");
		Image redcomboimg = redcomboicon.getImage();
		Image changeRedcomboImage = redcomboimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeRedcomboIcon = new ImageIcon(changeRedcomboImage);
		// 세븐레허반반
		ImageIcon redhoneyhalficon = new ImageIcon("chicken_images/redhoneyhalf.png");
		Image redhoneyhalfimg = redhoneyhalficon.getImage();
		Image changeRedhoneyhalfImage = redhoneyhalfimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeRedhoneyhalfIcon = new ImageIcon(changeRedhoneyhalfImage);
		// 세븐살살치킨
		ImageIcon salsalicon = new ImageIcon("chicken_images/salsal.png");
		Image salsalimg = salsalicon.getImage();
		Image changeSalsalImage = salsalimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSalsalIcon = new ImageIcon(changeSalsalImage);
		// 세븐신화오리지날
		ImageIcon shinhwaicon = new ImageIcon("chicken_images/shinhwa.png");
		Image shinhwaimg = shinhwaicon.getImage();
		Image changeShinhwaImage = shinhwaimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeShinhwaIcon = new ImageIcon(changeShinhwaImage);
		// 세븐시그니처세트
		ImageIcon signatureseticon = new ImageIcon("chicken_images/signatureset.png");
		Image signaturesetimg = signatureseticon.getImage();
		Image changeSignaturesetImage = signaturesetimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSignaturesetIcon = new ImageIcon(changeSignaturesetImage);
		
		// 치킨 버튼
		JButton cheeseTruffleBtn = new JButton(menu[0], changeCheeseTruffleIcon);
		JButton friedBtn = new JButton(menu[1], changeFriedIcon);
		JButton honeyBtn = new JButton(menu[2], changeHoneyIcon);
		JButton honeycomboBtn = new JButton(menu[3], changeHoneycomboIcon);
		JButton originalBtn = new JButton(menu[4], changeOriginalIcon);
		JButton originalhalfBtn = new JButton(menu[5], changeOriginalhalfIcon);
		JButton redBtn = new JButton(menu[6], changeRedIcon);
		JButton redcomboBtn = new JButton(menu[7], changeRedcomboIcon);
		JButton redhoneyhalfBtn = new JButton(menu[8], changeRedhoneyhalfIcon);
		JButton salsalBtn = new JButton(menu[9], changeSalsalIcon);
		JButton shinhwaBtn = new JButton(menu[10], changeShinhwaIcon);
		JButton signaturesetBtn = new JButton(menu[11], changeSignaturesetIcon);

		// 치킨 버튼 설정
		cheeseTruffleBtn.setBackground(Color.WHITE);
		cheeseTruffleBtn.setVerticalTextPosition(JButton.BOTTOM);
		cheeseTruffleBtn.setHorizontalTextPosition(JButton.CENTER);
		cheeseTruffleBtn.setFont(font);
		friedBtn.setBackground(Color.WHITE);
		friedBtn.setVerticalTextPosition(JButton.BOTTOM);
		friedBtn.setHorizontalTextPosition(JButton.CENTER);
		friedBtn.setFont(font);
		honeyBtn.setBackground(Color.WHITE);
		honeyBtn.setVerticalTextPosition(JButton.BOTTOM);
		honeyBtn.setHorizontalTextPosition(JButton.CENTER);
		honeyBtn.setFont(font);
		honeycomboBtn.setBackground(Color.WHITE);
		honeycomboBtn.setVerticalTextPosition(JButton.BOTTOM);
		honeycomboBtn.setHorizontalTextPosition(JButton.CENTER);
		honeycomboBtn.setFont(font);
		originalBtn.setBackground(Color.WHITE);
		originalBtn.setVerticalTextPosition(JButton.BOTTOM);
		originalBtn.setHorizontalTextPosition(JButton.CENTER);
		originalBtn.setFont(font);
		originalhalfBtn.setBackground(Color.WHITE);
		originalhalfBtn.setVerticalTextPosition(JButton.BOTTOM);
		originalhalfBtn.setHorizontalTextPosition(JButton.CENTER);
		originalhalfBtn.setFont(font);
		redBtn.setBackground(Color.WHITE);
		redBtn.setVerticalTextPosition(JButton.BOTTOM);
		redBtn.setHorizontalTextPosition(JButton.CENTER);
		redBtn.setFont(font);
		redcomboBtn.setBackground(Color.WHITE);
		redcomboBtn.setVerticalTextPosition(JButton.BOTTOM);
		redcomboBtn.setHorizontalTextPosition(JButton.CENTER);
		redcomboBtn.setFont(font);
		redhoneyhalfBtn.setBackground(Color.WHITE);
		redhoneyhalfBtn.setVerticalTextPosition(JButton.BOTTOM);
		redhoneyhalfBtn.setHorizontalTextPosition(JButton.CENTER);
		redhoneyhalfBtn.setFont(font);
		salsalBtn.setBackground(Color.WHITE);
		salsalBtn.setVerticalTextPosition(JButton.BOTTOM);
		salsalBtn.setHorizontalTextPosition(JButton.CENTER);
		salsalBtn.setFont(font);
		shinhwaBtn.setBackground(Color.WHITE);
		shinhwaBtn.setVerticalTextPosition(JButton.BOTTOM);
		shinhwaBtn.setHorizontalTextPosition(JButton.CENTER);
		shinhwaBtn.setFont(font);
		signaturesetBtn.setBackground(Color.WHITE);
		signaturesetBtn.setVerticalTextPosition(JButton.BOTTOM);
		signaturesetBtn.setHorizontalTextPosition(JButton.CENTER);
		signaturesetBtn.setFont(font);
		
		
		// 치킨 스크롤
		JScrollPane chickenjsp = new JScrollPane(
				containerChicken, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
	// 사이드 컴포넌트
		String[] menuSide = {"<HTML><body><center>세븐치즈볼<br>5,500원</center></body></HTML>",
				"<HTML><body><center>세븐치킨버거<br>4,900원</center></body></HTML>",
				"<HTML><body><center>세븐치킨카츠<br>6,000원</center></body></HTML>",
				"<HTML><body><center>세븐칠리포테이토<br>4,000원</center></body></HTML>",
				"<HTML><body><center>세븐칩카사바<br>1,500원</center></body></HTML>",
				"<HTML><body><center>세븐꽈배기<br>3,500원</center></body></HTML>",
				"<HTML><body><center>세븐웨지감자<br>3,500원</center></body></HTML>",
				"<HTML><body><center>치킨무<br>500원</center></body></HTML>",
				"<HTML><body><center>적피클<br>1,000원</center></body></HTML>",
				"<HTML><body><center>세븐샐러드<br>5,000원</center></body></HTML>",
				"<HTML><body><center>하바네로마요소스<br>1,000원</center></body></HTML>",
				"<HTML><body><center>허니갈릭소스<br>1,000원</center></body></HTML>",
				"<HTML><body><center>레드소스<br>1,000원</center></body></HTML>",
				"<HTML><body><center>스위트칠리소스<br>1,000원</center></body></HTML>",
				"<HTML><body><center>타르타르소스<br>1,000원</center></body></HTML>"};
		
		// 버튼에 이미지를 삽입하기 위해 Icon <-> Image 변환

		// 세븐치즈볼
		ImageIcon cheeseballicon = new ImageIcon("side_images/cheeseball.png");
		Image cheeseballimg = cheeseballicon.getImage();
		Image changeCheeseballImage = cheeseballimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeCheeseballIcon = new ImageIcon(changeCheeseballImage);
		// 세븐치킨버거
		ImageIcon chickenburgericon = new ImageIcon("side_images/chickenburger.png");
		Image chickenburgerimg = chickenburgericon.getImage();
		Image changeChickenburgerImage = chickenburgerimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeChickenburgerIcon = new ImageIcon(changeChickenburgerImage);
		// 세븐치킨카츠
		ImageIcon chickenkatzicon = new ImageIcon("side_images/chickenkatz.png");
		Image chickenkatzimg = chickenkatzicon.getImage();
		Image changeChickenkatzImage = chickenkatzimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeChickenkatzIcon = new ImageIcon(changeChickenkatzImage);
		// 세븐칠리포테이토
		ImageIcon chillypotatoicon = new ImageIcon("side_images/chillypotato.png");
		Image chillypotatoimg = chillypotatoicon.getImage();
		Image changeChillypotatoImage = chillypotatoimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeChillypotatoIcon = new ImageIcon(changeChillypotatoImage);
		// 세븐칩카사바
		ImageIcon chipcasabaicon = new ImageIcon("side_images/chipcasaba.png");
		Image chipcasabaimg = chipcasabaicon.getImage();
		Image changeChipcasabaImage = chipcasabaimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeChipcasabaIcon = new ImageIcon(changeChipcasabaImage);
		// 세븐꽈배기
		ImageIcon gguabegiicon = new ImageIcon("side_images/gguabegi.png");
		Image gguabegiimg = gguabegiicon.getImage();
		Image changeGguabegiImage = gguabegiimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeGguabegiIcon = new ImageIcon(changeGguabegiImage);
		// 세븐웨지감자
		ImageIcon potatowedgesicon = new ImageIcon("side_images/potatowedges.png");
		Image potatowedgesimg = potatowedgesicon.getImage();
		Image changePotatowedgesImage = potatowedgesimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changePotatowedgesIcon = new ImageIcon(changePotatowedgesImage);
		// 치킨무
		ImageIcon muicon = new ImageIcon("side_images/mu.png");
		Image muimg = muicon.getImage();
		Image changeMuImage = muimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeMuIcon = new ImageIcon(changeMuImage);
		// 적피클
		ImageIcon redpickleicon = new ImageIcon("side_images/redpickle.png");
		Image redpickleimg = redpickleicon.getImage();
		Image changeRedpickleImage = redpickleimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeRedpickleIcon = new ImageIcon(changeRedpickleImage);
		// 세븐샐러드
		ImageIcon saladicon = new ImageIcon("side_images/salad.png");
		Image saladimg = saladicon.getImage();
		Image changeSaladImage = saladimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSaladIcon = new ImageIcon(changeSaladImage);
		// 하바네로마요소스
		ImageIcon saucehabaneromayoicon = new ImageIcon("side_images/saucehabaneromayo.png");
		Image saucehabaneromayoimg = saucehabaneromayoicon.getImage();
		Image changeSaucehabaneromayoImage = saucehabaneromayoimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSaucehabaneromayoIcon = new ImageIcon(changeSaucehabaneromayoImage);
		// 허니갈릭소스
		ImageIcon saucehoneygarlicicon = new ImageIcon("side_images/saucehoneygarlic.png");
		Image saucehoneygarlicimg = saucehoneygarlicicon.getImage();
		Image changeSaucehoneygarlicImage = saucehoneygarlicimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSaucehoneygarlicIcon = new ImageIcon(changeSaucehoneygarlicImage);
		// 레드소스
		ImageIcon sauceredicon = new ImageIcon("side_images/saucered.png");
		Image sauceredimg = sauceredicon.getImage();
		Image changeSauceredImage = sauceredimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSauceredIcon = new ImageIcon(changeSauceredImage);
		// 스위트칠리소스
		ImageIcon saucesweetchillyicon = new ImageIcon("side_images/saucesweetchilly.png");
		Image saucesweetchillyimg = saucesweetchillyicon.getImage();
		Image changeSaucesweetchillyImage = saucesweetchillyimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSaucesweetchillyIcon = new ImageIcon(changeSaucesweetchillyImage);
		// 타르타르소스
		ImageIcon saucetartareicon = new ImageIcon("side_images/saucetartare.png");
		Image saucetartareimg = saucetartareicon.getImage();
		Image changeSaucetartareImage = saucetartareimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSaucetartareIcon = new ImageIcon(changeSaucetartareImage);

		// 사이드 버튼
		JButton cheeseballBtn = new JButton(menuSide[0], changeCheeseballIcon);
		JButton chickenburgerBtn = new JButton(menuSide[1], changeChickenburgerIcon);
		JButton chickenkatzBtn = new JButton(menuSide[2], changeChickenkatzIcon);
		JButton chillypotatoBtn = new JButton(menuSide[3], changeChillypotatoIcon);
		JButton chipcasabaBtn = new JButton(menuSide[4], changeChipcasabaIcon);
		JButton gguabegiBtn = new JButton(menuSide[5], changeGguabegiIcon);
		JButton potatowedgesBtn = new JButton(menuSide[6], changePotatowedgesIcon);
		JButton muBtn = new JButton(menuSide[7], changeMuIcon);
		JButton redpickleBtn = new JButton(menuSide[8], changeRedpickleIcon);
		JButton saladBtn = new JButton(menuSide[9], changeSaladIcon);
		JButton saucehabaneromayoBtn = new JButton(menuSide[10], changeSaucehabaneromayoIcon);
		JButton saucehoneygarlicBtn = new JButton(menuSide[11], changeSaucehoneygarlicIcon);
		JButton sauceredBtn = new JButton(menuSide[12], changeSauceredIcon);
		JButton saucesweetchillyBtn = new JButton(menuSide[13], changeSaucesweetchillyIcon);
		JButton saucetartareBtn = new JButton(menuSide[14], changeSaucetartareIcon);
		
		// 사이드 버튼 설정
		cheeseballBtn.setBackground(Color.WHITE);
		cheeseballBtn.setVerticalTextPosition(JButton.BOTTOM);
		cheeseballBtn.setHorizontalTextPosition(JButton.CENTER);
		cheeseballBtn.setFont(font);
		chickenburgerBtn.setBackground(Color.WHITE);
		chickenburgerBtn.setVerticalTextPosition(JButton.BOTTOM);
		chickenburgerBtn.setHorizontalTextPosition(JButton.CENTER);
		chickenburgerBtn.setFont(font);
		chickenkatzBtn.setBackground(Color.WHITE);
		chickenkatzBtn.setVerticalTextPosition(JButton.BOTTOM);
		chickenkatzBtn.setHorizontalTextPosition(JButton.CENTER);
		chickenkatzBtn.setFont(font);
		chillypotatoBtn.setBackground(Color.WHITE);
		chillypotatoBtn.setVerticalTextPosition(JButton.BOTTOM);
		chillypotatoBtn.setHorizontalTextPosition(JButton.CENTER);
		chillypotatoBtn.setFont(font);
		chipcasabaBtn.setBackground(Color.WHITE);
		chipcasabaBtn.setVerticalTextPosition(JButton.BOTTOM);
		chipcasabaBtn.setHorizontalTextPosition(JButton.CENTER);
		chipcasabaBtn.setFont(font);
		gguabegiBtn.setBackground(Color.WHITE);
		gguabegiBtn.setVerticalTextPosition(JButton.BOTTOM);
		gguabegiBtn.setHorizontalTextPosition(JButton.CENTER);
		gguabegiBtn.setFont(font);
		potatowedgesBtn.setBackground(Color.WHITE);
		potatowedgesBtn.setVerticalTextPosition(JButton.BOTTOM);
		potatowedgesBtn.setHorizontalTextPosition(JButton.CENTER);
		potatowedgesBtn.setFont(font);
		muBtn.setBackground(Color.WHITE);
		muBtn.setVerticalTextPosition(JButton.BOTTOM);
		muBtn.setHorizontalTextPosition(JButton.CENTER);
		muBtn.setFont(font);
		redpickleBtn.setBackground(Color.WHITE);
		redpickleBtn.setVerticalTextPosition(JButton.BOTTOM);
		redpickleBtn.setHorizontalTextPosition(JButton.CENTER);
		redpickleBtn.setFont(font);
		saladBtn.setBackground(Color.WHITE);
		saladBtn.setVerticalTextPosition(JButton.BOTTOM);
		saladBtn.setHorizontalTextPosition(JButton.CENTER);
		saladBtn.setFont(font);
		saucehabaneromayoBtn.setBackground(Color.WHITE);
		saucehabaneromayoBtn.setVerticalTextPosition(JButton.BOTTOM);
		saucehabaneromayoBtn.setHorizontalTextPosition(JButton.CENTER);
		saucehabaneromayoBtn.setFont(font);
		saucehoneygarlicBtn.setBackground(Color.WHITE);
		saucehoneygarlicBtn.setVerticalTextPosition(JButton.BOTTOM);
		saucehoneygarlicBtn.setHorizontalTextPosition(JButton.CENTER);
		saucehoneygarlicBtn.setFont(font);
		sauceredBtn.setBackground(Color.WHITE);
		sauceredBtn.setVerticalTextPosition(JButton.BOTTOM);
		sauceredBtn.setHorizontalTextPosition(JButton.CENTER);
		sauceredBtn.setFont(font);
		saucesweetchillyBtn.setBackground(Color.WHITE);
		saucesweetchillyBtn.setVerticalTextPosition(JButton.BOTTOM);
		saucesweetchillyBtn.setHorizontalTextPosition(JButton.CENTER);
		saucesweetchillyBtn.setFont(font);
		saucetartareBtn.setBackground(Color.WHITE);
		saucetartareBtn.setVerticalTextPosition(JButton.BOTTOM);
		saucetartareBtn.setHorizontalTextPosition(JButton.CENTER);
		saucetartareBtn.setFont(font);
		
		// 사이드 버튼 스크롤
		JScrollPane sidejsp = new JScrollPane(
				containerSide, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
	// 움료 컴포넌트
		String[] menuDrink = {"<HTML><body><center>코카콜라<br>2,000원</center></body></HTML>",
				"<HTML><body><center>스프라이트<br>2,000원</center></body></HTML>",
				"<HTML><body><center>환타<br>2,000원</center></body></HTML>",
				"<HTML><body><center>한라산맥주<br>11,000원</center></body></HTML>",
				"<HTML><body><center>허니스파클링<br>3,000원</center></body></HTML>",
				"<HTML><body><center>생맥주<br>7,000원</center></body></HTML>"};
		
		// 버튼에 이미지를 삽입하기 위해 Icon <-> Image 변환

		// 코카콜라
		ImageIcon cokeicon = new ImageIcon("drink_images/coke.png");
		Image cokeimg = cokeicon.getImage();
		Image changeCokeImage = cokeimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeCokeIcon = new ImageIcon(changeCokeImage);
		// 스프라이트
		ImageIcon spriteicon = new ImageIcon("drink_images/sprite.png");
		Image spriteimg = spriteicon.getImage();
		Image changeSpriteImage = spriteimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeSpriteIcon = new ImageIcon(changeSpriteImage);
		// 환타
		ImageIcon fantaicon = new ImageIcon("drink_images/fanta.png");
		Image fantaimg = fantaicon.getImage();
		Image changeFantaImage = fantaimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeFantaIcon = new ImageIcon(changeFantaImage);
		// 한라산맥주
		ImageIcon hanlasanbeericon = new ImageIcon("drink_images/hanlasanbeer.png");
		Image hanlasanbeerimg = hanlasanbeericon.getImage();
		Image changeHanlasanbeerImage = hanlasanbeerimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeHanlasanbeerIcon = new ImageIcon(changeHanlasanbeerImage);
		// 허니스파클링
		ImageIcon honeysparklingicon = new ImageIcon("drink_images/honeysparkling.png");
		Image honeysparklingimg = honeysparklingicon.getImage();
		Image changeHoneysparklingImage = honeysparklingimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeHoneysparklingIcon = new ImageIcon(changeHoneysparklingImage);
		// 생맥주
		ImageIcon draftbeericon = new ImageIcon("drink_images/draftbeer.png");
		Image draftbeerimg = draftbeericon.getImage();
		Image changeDraftbeerImage = draftbeerimg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon changeDraftbeerIcon = new ImageIcon(changeDraftbeerImage);
		
		// 음료 버튼
		JButton cokeBtn = new JButton(menuDrink[0], changeCokeIcon);
		JButton spriteBtn = new JButton(menuDrink[1], changeSpriteIcon);
		JButton fantaBtn = new JButton(menuDrink[2], changeFantaIcon);
		JButton hanlasanbeerBtn = new JButton(menuDrink[3], changeHanlasanbeerIcon);
		JButton honeysparklingBtn = new JButton(menuDrink[4], changeHoneysparklingIcon);
		JButton draftbeerBtn = new JButton(menuDrink[5], changeDraftbeerIcon);
		
		// 음료 버튼 설정
		cokeBtn.setBackground(Color.WHITE);
		cokeBtn.setVerticalTextPosition(JButton.BOTTOM);
		cokeBtn.setHorizontalTextPosition(JButton.CENTER);
		cokeBtn.setFont(font);
		spriteBtn.setBackground(Color.WHITE);
		spriteBtn.setVerticalTextPosition(JButton.BOTTOM);
		spriteBtn.setHorizontalTextPosition(JButton.CENTER);
		spriteBtn.setFont(font);
		fantaBtn.setBackground(Color.WHITE);
		fantaBtn.setVerticalTextPosition(JButton.BOTTOM);
		fantaBtn.setHorizontalTextPosition(JButton.CENTER);
		fantaBtn.setFont(font);
		hanlasanbeerBtn.setBackground(Color.WHITE);
		hanlasanbeerBtn.setVerticalTextPosition(JButton.BOTTOM);
		hanlasanbeerBtn.setHorizontalTextPosition(JButton.CENTER);
		hanlasanbeerBtn.setFont(font);
		honeysparklingBtn.setBackground(Color.WHITE);
		honeysparklingBtn.setVerticalTextPosition(JButton.BOTTOM);
		honeysparklingBtn.setHorizontalTextPosition(JButton.CENTER);
		honeysparklingBtn.setFont(font);
		draftbeerBtn.setBackground(Color.WHITE);
		draftbeerBtn.setVerticalTextPosition(JButton.BOTTOM);
		draftbeerBtn.setHorizontalTextPosition(JButton.CENTER);
		draftbeerBtn.setFont(font);
		
		// 음료 버튼 스크롤
		JScrollPane drinkjsp = new JScrollPane(
				containerDrink, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
	// 하단 버튼
		result = _2_Log.result;
		count = _2_Log.count;
		
		JButton toLog = new JButton("처음으로");
		JLabel emptyjlb0 = new JLabel("    ");
		cartBtn = new JButton("장바구니  " + count + "개");
		JButton orderBtn = new JButton("결제하기");
		JLabel emptyjlb = new JLabel("    ");
		JLabel resultPriceText = new JLabel("                           총 금액 : ");
		JLabel resultPrice = new JLabel(formatter.format(result) + "원");
		
		toLog.setFont(font);
		toLog.setBackground(Color.WHITE);
		cartBtn.setFont(font);
		cartBtn.setBackground(Color.WHITE);
		orderBtn.setFont(font);
		orderBtn.setBackground(Color.WHITE);
		resultPriceText.setFont(font);
		resultPrice.setFont(font);
		
	// 컴포넌트 올리기
		// 치킨 컨테이너
		containerChicken.add(cheeseTruffleBtn);	containerChicken.add(friedBtn);
		containerChicken.add(honeyBtn);			containerChicken.add(honeycomboBtn);
		containerChicken.add(originalBtn);		containerChicken.add(originalhalfBtn);
		containerChicken.add(redBtn);			containerChicken.add(redcomboBtn);
		containerChicken.add(redhoneyhalfBtn);	containerChicken.add(salsalBtn);
		containerChicken.add(shinhwaBtn);		containerChicken.add(signaturesetBtn);
		containerChicken.setBackground(Color.ORANGE);
		
		// 사이드 컨테이너
		containerSide.add(cheeseballBtn);		 containerSide.add(chickenburgerBtn);	
		containerSide.add(chickenkatzBtn);		 containerSide.add(chillypotatoBtn);	
		containerSide.add(chipcasabaBtn);		 containerSide.add(gguabegiBtn);	
		containerSide.add(potatowedgesBtn);		 containerSide.add(muBtn);	
		containerSide.add(redpickleBtn);		 containerSide.add(saladBtn);	
		containerSide.add(saucehabaneromayoBtn); containerSide.add(saucehoneygarlicBtn);	
		containerSide.add(sauceredBtn);			 containerSide.add(saucesweetchillyBtn);	
		containerSide.add(saucetartareBtn);
		containerSide.setBackground(Color.ORANGE);
		
		// 음료 컨테이너
		containerDrink.add(cokeBtn);	containerDrink.add(spriteBtn);
		containerDrink.add(fantaBtn);	containerDrink.add(hanlasanbeerBtn);
		containerDrink.add(honeysparklingBtn);	containerDrink.add(draftbeerBtn);
		containerDrink.setBackground(Color.ORANGE);
		
		// 하단 버튼
		southButton.add(toLog);
		southButton.add(emptyjlb0);
		southButton.add(cartBtn);
		southButton.add(emptyjlb);
		southButton.add(orderBtn);
		southButton.add(resultPriceText);
		southButton.add(resultPrice);
		southButton.setBackground(Color.ORANGE);
		
	// 프레임에 올리기
		tab.add("치킨", chickenjsp);
		tab.add("사이드", sidejsp);
		tab.add("음료", drinkjsp);
		
		tab.setFont(font);
		
		add(tab, BorderLayout.CENTER);
		add(southButton, BorderLayout.SOUTH);
			 
		// 창 설정
		setBounds(200,200,630,700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		connect();
		
//		// 초기화면으로 이동
//		updateCounttoZero();	// 주문수량 = 0으로 변경.

	// 이벤트 처리
	// 치킨
		cheeseTruffleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				
				int inven = getInven("세븐치즈트러플");
				
				++cheesetrufflecount;
				_2_Log.cheesetrufflecount = cheesetrufflecount;

				if(inven >= cheesetrufflecount) {
					count++;
					result += 19000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--cheesetrufflecount;
					_2_Log.cheesetrufflecount = cheesetrufflecount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				String name = "세븐치즈트러플";
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, cheesetrufflecount);
					pstmt.setString(2, name);
					
					int res = pstmt.executeUpdate();
					
//					if(res > 0) {
//						JOptionPane.showMessageDialog(null, "성공");
//					} else {
//						JOptionPane.showMessageDialog(null, "실패");
//					}
					
					pstmt.close(); con.close();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		friedBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐후라이드");
				
				++friedcount;
				_2_Log.friedcount = friedcount;
				
				if(inven >= friedcount) {
					count++;
					result += 17500;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--friedcount;
					_2_Log.friedcount = friedcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, friedcount);
					pstmt.setString(2, "세븐후라이드");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		honeyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐허니오리지날");
				
				++honeycount;
				_2_Log.honeycount = honeycount;
				
				if(inven >= honeycount) {
					count++;
					result += 16000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--honeycount;
					_2_Log.honeycount = honeycount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, honeycount);
					pstmt.setString(2, "세븐허니오리지날");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		honeycomboBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐허니콤보");
				
				++honeycombocount;
				_2_Log.honeycombocount = honeycombocount;
				
				if(inven >= honeycombocount) {
					count++;
					result += 20000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--honeycombocount;
					_2_Log.honeycombocount = honeycombocount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, honeycombocount);
					pstmt.setString(2, "세븐허니콤보");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		originalBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐오리지날");
				
				++originalcount;
				_2_Log.originalcount = originalcount;
				
				if(inven >= originalcount) {
					count++;
					result += 16000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--originalcount;
					_2_Log.originalcount = originalcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, originalcount);
					pstmt.setString(2, "세븐오리지날");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		originalhalfBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐오리지날반반");
				
				++originalhalfcount;
				_2_Log.originalhalfcount = originalhalfcount;
				
				if(inven >= originalhalfcount) {
					count++;
					result += 17000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--originalhalfcount;
					_2_Log.originalhalfcount = originalhalfcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, originalhalfcount);
					pstmt.setString(2, "세븐오리지날반반");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		redBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐레드오리지날");
				
				++redcount;
				_2_Log.redcount = redcount;
				
				if(inven >= redcount) {
					count++;
					result += 17000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--redcount;
					_2_Log.redcount = redcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, redcount);
					pstmt.setString(2, "세븐레드오리지날");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		redcomboBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐레드콤보");
				
				++redcombocount;
				_2_Log.redcombocount = redcombocount;
				
				if(inven >= redcombocount) {
					count++;
					result += 20000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--redcombocount;
					_2_Log.redcombocount = redcombocount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, redcombocount);
					pstmt.setString(2, "세븐레드콤보");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		redhoneyhalfBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐레허반반");
				
				++redhoneyhalfcount;
				_2_Log.redhoneyhalfcount = redhoneyhalfcount;
				
				if(inven >= redhoneyhalfcount) {
					count++;
					result += 22000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--redhoneyhalfcount;
					_2_Log.redhoneyhalfcount = redhoneyhalfcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, redhoneyhalfcount);
					pstmt.setString(2, "세븐레허반반");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		salsalBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐살살치킨");
				
				++salsalcount;
				_2_Log.salsalcount = salsalcount;
				
				if(inven >= salsalcount) {
					count++;
					result += 17000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--salsalcount;
					_2_Log.salsalcount = salsalcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, salsalcount);
					pstmt.setString(2, "세븐살살치킨");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		shinhwaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐신화오리지날");
				
				++shinhwacount;
				_2_Log.shinhwacount = shinhwacount;
				
				if(inven >= shinhwacount) {
					count++;
					result += 18000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--shinhwacount;
					_2_Log.shinhwacount = shinhwacount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, shinhwacount);
					pstmt.setString(2, "세븐신화오리지날");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		signaturesetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐시그니처세트");
				
				++signaturesetcount;
				_2_Log.signaturesetcount = signaturesetcount;
				
				if(inven >= signaturesetcount) {
					count++;
					result += 27500;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--signaturesetcount;
					_2_Log.signaturesetcount = signaturesetcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, signaturesetcount);
					pstmt.setString(2, "세븐시그니처세트");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
	// 사이드
		cheeseballBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐치즈볼");
				
				++cheeseballcount;
				_2_Log.cheeseballcount = cheeseballcount;
							
				if(inven >= cheeseballcount) {
					count++;
					result += 5500;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--cheeseballcount;
					_2_Log.cheeseballcount = cheeseballcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, cheeseballcount);
					pstmt.setString(2, "세븐치즈볼");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		chickenburgerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐치킨버거");
				
				++chickenburgercount;
				_2_Log.chickenburgercount = chickenburgercount;
				
				if(inven >= chickenburgercount) {
					count++;
					result += 4900;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");

				} else {
					--chickenburgercount;
					_2_Log.chickenburgercount = chickenburgercount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, chickenburgercount);
					pstmt.setString(2, "세븐치킨버거");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		chickenkatzBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐치킨카츠");
				
				++chickenkatzcount;
				_2_Log.chickenkatzcount = chickenkatzcount;
				
				if(inven >= chickenkatzcount) {
					count++;
					result += 6000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--chickenkatzcount;
					_2_Log.chickenkatzcount = chickenkatzcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, chickenkatzcount);
					pstmt.setString(2, "세븐치킨카츠");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		chillypotatoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐칠리포테이토");
				
				++chillypotatocount;
				_2_Log.chillypotatocount = chillypotatocount;
				
				if(inven >= chillypotatocount) {
					count++;
					result += 4000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--chillypotatocount;
					_2_Log.chillypotatocount = chillypotatocount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, chillypotatocount);
					pstmt.setString(2, "세븐칠리포테이토");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		chipcasabaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐칩카사바");
				
				++chipcasabacount;
				_2_Log.chipcasabacount = chipcasabacount;
				
				if(inven >= chipcasabacount) {
					count++;
					result += 1500;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--chipcasabacount;
					_2_Log.chipcasabacount = chipcasabacount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, chipcasabacount);
					pstmt.setString(2, "세븐칩카사바");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		gguabegiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐꽈배기");
				
				++gguabegicount;
				_2_Log.gguabegicount = gguabegicount;
				
				if(inven >= gguabegicount) {
					count++;
					result += 3500;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--gguabegicount;
					_2_Log.gguabegicount = gguabegicount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, gguabegicount);
					pstmt.setString(2, "세븐꽈배기");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		potatowedgesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐웨지감자");
				
				++potatowedgescount;
				_2_Log.potatowedgescount = potatowedgescount;
				
				if(inven >= potatowedgescount) {
					count++;
					result += 3500;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--potatowedgescount;
					_2_Log.potatowedgescount = potatowedgescount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, potatowedgescount);
					pstmt.setString(2, "세븐웨지감자");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		muBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("치킨무");
				
				++mucount;
				_2_Log.mucount = mucount;
				
				if(inven >= mucount) {
					count++;
					result += 500;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--mucount;
					_2_Log.mucount = mucount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, mucount);
					pstmt.setString(2, "치킨무");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		redpickleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("적피클");
				
				++redpicklecount;
				_2_Log.redpicklecount = redpicklecount;
				
				if(inven >= redpicklecount) {
					count++;
					result += 1000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--redpicklecount;
					_2_Log.redpicklecount = redpicklecount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, redpicklecount);
					pstmt.setString(2, "적피클");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		saladBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("세븐샐러드");
				
				++saladcount;
				_2_Log.saladcount = saladcount;
				
				if(inven >= saladcount) {
					count++;
					result += 5000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--saladcount;
					_2_Log.saladcount = saladcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, saladcount);
					pstmt.setString(2, "세븐샐러드");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		saucehabaneromayoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("하바네로마요소스");
				
				++saucehabaneromayocount;
				_2_Log.saucehabaneromayocount = saucehabaneromayocount;
				
				if(inven >= saucehabaneromayocount) {
					count++;
					result += 1000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--saucehabaneromayocount;
					_2_Log.saucehabaneromayocount = saucehabaneromayocount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, saucehabaneromayocount);
					pstmt.setString(2, "하바네로마요소스");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		saucehoneygarlicBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("허니갈릭소스");
				
				++saucehoneygarliccount;
				_2_Log.saucehoneygarliccount = saucehoneygarliccount;
				
				if(inven >= saucehoneygarliccount) {
					count++;
					result += 1000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--saucehoneygarliccount;
					_2_Log.saucehoneygarliccount = saucehoneygarliccount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, saucehoneygarliccount);
					pstmt.setString(2, "허니갈릭소스");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		sauceredBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("레드소스");
				
				++sauceredcount;
				_2_Log.sauceredcount = sauceredcount;
				
				if(inven >= sauceredcount) {
					count++;
					result += 1000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--sauceredcount;
					_2_Log.sauceredcount = sauceredcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, sauceredcount);
					pstmt.setString(2, "레드소스");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		saucesweetchillyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("스위트칠리소스");
				
				++saucesweetchillycount;
				_2_Log.saucesweetchillycount = saucesweetchillycount;
				
				if(inven >= saucesweetchillycount) {
					count++;
					result += 1000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--saucesweetchillycount;
					_2_Log.saucesweetchillycount = saucesweetchillycount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, saucesweetchillycount);
					pstmt.setString(2, "스위트칠리소스");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		saucetartareBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("타르타르소스");
				
				++saucetartarecount;
				_2_Log.saucetartarecount = saucetartarecount;
				
				if(inven >= saucetartarecount) {
					count++;
					result += 1000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--saucetartarecount;
					_2_Log.saucetartarecount = saucetartarecount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, saucetartarecount);
					pstmt.setString(2, "타르타르소스");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
	// 음료
		cokeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("코카콜라");
				
				++cokecount;
				_2_Log.cokecount = cokecount;
				
				if(inven >= cokecount) {
					count++;
					result += 2000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--cokecount;
					_2_Log.cokecount = cokecount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, cokecount);
					pstmt.setString(2, "코카콜라");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		spriteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("스프라이트");
				
				++spritecount;
				_2_Log.spritecount = spritecount;
				
				if(inven >= spritecount) {
					count++;
					result += 2000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--spritecount;
					_2_Log.spritecount = spritecount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, spritecount);
					pstmt.setString(2, "스프라이트");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		fantaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("환타");
				
				++fantacount;
				_2_Log.fantacount = fantacount;
				
				if(inven >= fantacount) {
					count++;
					result += 2000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--fantacount;
					_2_Log.fantacount = fantacount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, fantacount);
					pstmt.setString(2, "환타");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		hanlasanbeerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("한라산맥주");
				
				++hanlasanbeercount;
				_2_Log.hanlasanbeercount = hanlasanbeercount;
				
				if(inven >= hanlasanbeercount) {
					count++;
					result += 11000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--hanlasanbeercount;
					_2_Log.hanlasanbeercount = hanlasanbeercount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, hanlasanbeercount);
					pstmt.setString(2, "한라산맥주");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		honeysparklingBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("허니스파클링");
				
				++honeysparklingcount;
				_2_Log.honeysparklingcount = honeysparklingcount;
				
				if(inven >= honeysparklingcount) {
					count++;
					result += 3000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--honeysparklingcount;
					_2_Log.honeysparklingcount = honeysparklingcount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}
				
				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, honeysparklingcount);
					pstmt.setString(2, "허니스파클링");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		draftbeerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect();
				int inven = getInven("생맥주");
				
				++draftbeercount;
				_2_Log.draftbeercount = draftbeercount;
				
				if(inven >= draftbeercount) {
					count++;
					result += 7000;
					resultPrice.setText(formatter.format(result) + "원");
					cartBtn.setText("장바구니  " + count + "개");
				} else {
					--draftbeercount;
					_2_Log.draftbeercount = draftbeercount;
					JOptionPane.showMessageDialog(null, "해당 상품의 재고가 부족합니다.");
				}

				try {
					sql = "update menutable set menu_count = ? where menu_name = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, draftbeercount);
					pstmt.setString(2, "생맥주");
					
					int res = pstmt.executeUpdate();
					
					pstmt.close(); con.close();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		// 처음으로 버튼
		toLog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new _2_Log();
				dispose();
			}
		});
		
		// 장바구니 버튼
		cartBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				_2_Log.count = count;
				_2_Log.result = result;
				dispose();
				new _7_Cart();
			}
		});
		
		// 결제하기 버튼
		orderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// DB에 result 값 넘겨주기
				connect();
				menuResultToDB();
				dispose();
				new _9_Counter();	// 결제 화면
			}
		});
		
	}	// 생성자 end
	
	// 민초님 connect()
	void connect() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";
		String user = "web";
		String password = "1234";

		try {
			// 1. 접속할 오라클 데이터베이스 드라이버를 메모리에 올리자
			Class.forName(driver);

			// 2. 오라클 데이터베이스와 연결을 시도
			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	// connect() 메서드 end
	
	// 초기화면으로 이동
//	// 처음 실행 시 주문수량을 0으로 변경.
//	public void updateCounttoZero() {
//	
//		try {
//			sql = "update menutable set menu_count = ? where menu_count > 0";
//			
//			pstmt = con.prepareStatement(sql);
//			
//			pstmt.setInt(1, 0);
//			
//			int res = pstmt.executeUpdate();
//			
//			if(res > 0) {
//				JOptionPane.showMessageDialog(null, "쿼리문 전송 성공");
//			} else {
//				JOptionPane.showMessageDialog(null, "쿼리문 전송 실패");
//			}
//			
//			pstmt.close();  // con.close();
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//	}	// updateCounttoZero() 메서드 end
//	
//	// 커밋
//	public void commit() {
//	
//		try {
//			sql = "commit";
//			
//			pstmt = con.prepareStatement(sql);
//			
//			int res = pstmt.executeUpdate();
//			
//			if(res > 0) {
//				JOptionPane.showMessageDialog(null, "커밋 성공");
//			} else {
//				JOptionPane.showMessageDialog(null, "커밋 실패");
//			}
//			
//			pstmt.close();  con.close();
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//	}	// commit() 메서드 end

	// 결과값 DB에 전달
	public void menuResultToDB() {
		
		try {
			// 1. 오라클 데이터베이스에 전송할 SQL문 작성.
			sql = "insert into ordertable values(order_seq.nextval, sysdate || ' ' || TO_CHAR(SYSDATE, 'HH24:MI:SS'), ?, '대기중')";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, result);

			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행.
			int res = pstmt.executeUpdate();
		
//			if(res > 0) {
//				JOptionPane.showMessageDialog(null, "결과 전송 성공");
//			} else {
//				JOptionPane.showMessageDialog(null, "결과 전송 실패");
//			}
			
			// 3. 오라클 데이터베이스에 연결되어 있던 자원 종료.
			pstmt.close();  con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	int getInven(String str) {
		
		int invenCount = 0;
		
		try {
			sql = "select menu_count from menu_inven where menu_name = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, str);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				invenCount = rs.getInt("menu_count");
			}
			
			rs.close(); pstmt.close(); 
			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		return invenCount;
	
	}	// getInven() 메서드 end
	
//	// main
//	public static void main(String[] args) {
//		
//		new _6_Menu();
//	}
}

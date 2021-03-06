package Testing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Your_aim extends JFrame {
	JPanel game_panel, intro_panel, ranking_panel, option_panel;
	JButton push_bt_1, push_bt_2, push_bt_3;
	JButton start_bt, exit_bt, ranking_bt, back_bt_1, back_bt_2, back_bt_3, option_bt;
	JButton red_bt, yellow_bt, blue_bt, green_bt, orange_bt;

	JLabel score_label, time_label;
	JLabel gamepad_label, trophy_label, out_label;
	JLabel user_1, user_2, user_3, user_4, user_5, user_6, user_7, user_8, user_9, user_10;
	JLabel muzi_label;

	ImageIcon intro_image = new ImageIcon("./bt_images/intro_1.jpg");
	ImageIcon ranking_intro_image = new ImageIcon("./bt_images/ranking_panel.jpg");
	ImageIcon start_bt_image = new ImageIcon("./bt_images/start_bt_image.jpg");
	ImageIcon ranking_bt_image = new ImageIcon("./bt_images/ranking_bt_image.jpg");
	ImageIcon exit_bt_image = new ImageIcon("./bt_images/exit_bt_image.jpg");
	ImageIcon gamepad_image = new ImageIcon("./bt_images/gamepad_image.png");
	ImageIcon trophy_image = new ImageIcon("./bt_images/trophy_image.png");
	ImageIcon out_image = new ImageIcon("./bt_images/out_image.png");
	ImageIcon red_aim_image = new ImageIcon("./bt_images/red_aim_image.gif");
	ImageIcon yellow_aim_image= new ImageIcon("./bt_images/yellow_aim_image.gif");
	ImageIcon blue_aim_image= new ImageIcon("./bt_images/blue_aim_image.gif");
	ImageIcon green_aim_image= new ImageIcon("./bt_images/green_aim_image.gif");
	ImageIcon orange_aim_image= new ImageIcon("./bt_images/orange_aim_image.gif");
	ImageIcon back_bt_image = new ImageIcon("./bt_images/back_bt_image.jpg");
	ImageIcon option_bt_image = new ImageIcon("./bt_images/option_bt_image.jpg");
	ImageIcon option_panel_image = new ImageIcon("./bt_images/option_panel_image.jpg");
	ImageIcon game_panel_image = new ImageIcon("./bt_images/game_panel_image.jpg");
	ImageIcon muzi_image = new ImageIcon("./bt_images/muzi_image.jpg");

	int random_x_one = (int) (Math.random() * 1141 + 60);
	int random_y_one = (int) (Math.random() * 701 + 100);
	int random_x_two = (int) (Math.random() * 1141 + 60);
	int random_y_two = (int) (Math.random() * 701 + 100);
	int random_x_three = (int) (Math.random() * 1141 + 60);
	int random_y_three = (int) (Math.random() * 701 + 100);
	int random_time_one = (int) (Math.random() * 291 + 10);
	int random_time_two = (int) (Math.random() * 291 + 10);
	int random_time_three = (int) (Math.random() * 291 + 10);

	int score = 0; // ??????
	int time; // ??????
	int music_time = 0; // ???????????? ?????? ????????? ?????? ??????
	int next_user = 0; // ?????? ??????
	int result_print = 0; // ??????????????? ????????? ????????? ?????? ??????
	int eye_fake = 0; // ????????????: 0 ?????? ?????? ???????????? ?????? ???????????? ??????

	boolean tf = true;

	String[][] student_info = new String[1000][2];

	File tik_file = new File("./music/Tik.wav");
	File page_skip_file = new File("./music/page_skip.wav");
	File back_file = new File("./music/back.wav");
	File bgm_file = new File("./music/back_ground_music.wav");
	File select_bt_sounds_file = new File("./music/select_bt_sounds.wav");

	public Your_aim() {
		setTitle("?????? ?????????");
		setSize(1280, 1020);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		////////////////////////////////////////////////////////
		
		try { // ?????? ??????
			AudioInputStream stream = AudioSystem.getAudioInputStream(bgm_file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch (Exception e2) {

			e2.printStackTrace();
		}
		
		/////////////////////////////////////////////////////////

		for (int k = 0; k < student_info.length; k++) {
			for (int z = 0; z < student_info[k].length; z++) {
				student_info[k][z] = "0";
			}
		}

		//////////////////////////////////////////////////////

		intro_panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(intro_image.getImage(), 0, 0, null);
			}
		};

		back_bt_1 = new JButton(back_bt_image); // ?????? ??? ????????????
		back_bt_2 = new JButton(back_bt_image); // ?????? ??? ????????????

		back_bt_1.setBounds(1050, 15, 150, 80);
		back_bt_2.setBounds(1050, 15, 150, 80);

		intro_panel.setLayout(null);
		start_bt = new JButton(start_bt_image);
		ranking_bt = new JButton(ranking_bt_image);
		exit_bt = new JButton(exit_bt_image);
		gamepad_label = new JLabel(gamepad_image);
		trophy_label = new JLabel(trophy_image);
		out_label = new JLabel(out_image);
		option_bt = new JButton(option_bt_image);
		option_bt.setBorderPainted(false);

		start_bt.setBounds(493, 680, 300, 50);
		ranking_bt.setBounds(493, 735, 300, 50);
		exit_bt.setBounds(493, 790, 300, 50);
		gamepad_label.setBounds(443, 685, 40, 40);
		trophy_label.setBounds(443, 740, 40, 40);
		out_label.setBounds(443, 797, 40, 40);
		option_bt.setBounds(820, 720, 81, 75);

		intro_panel.add(start_bt);
		intro_panel.add(ranking_bt);
		intro_panel.add(exit_bt);
		intro_panel.add(gamepad_label);
		intro_panel.add(trophy_label);
		intro_panel.add(out_label);
		intro_panel.add(option_bt);

		/////////////////////////////////////////////////////////////
		game_panel = new JPanel();
		game_panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(game_panel_image.getImage(), 0, 0, null);
			}
		};
		game_panel.setLayout(null);

		score_label = new JLabel("??????: 0");
		score_label.setFont(new Font("Dialog", Font.BOLD, 40));
		time_label = new JLabel("????????????: 30");
		time_label.setFont(new Font("Dialog", Font.BOLD, 40));

		push_bt_1 = new JButton(red_aim_image);
		push_bt_2 = new JButton(red_aim_image);
		push_bt_3 = new JButton(red_aim_image);

		push_bt_1.setBounds(random_x_one, random_y_one, 50, 50);
		push_bt_2.setBounds(random_x_two, random_y_two, 50, 50);
		push_bt_3.setBounds(random_x_three, random_y_three, 50, 50);
		push_bt_1.setBorderPainted(false);
		push_bt_2.setBorderPainted(false);
		push_bt_3.setBorderPainted(false);
		score_label.setBounds(300, -200, 500, 500);
		time_label.setBounds(600, -200, 500, 500);

		game_panel.add(back_bt_1);
		game_panel.add(push_bt_1);
		game_panel.add(push_bt_2);
		game_panel.add(push_bt_3);
		game_panel.add(score_label);
		game_panel.add(time_label);

		/////////////////////////////////////////////////////////////

		option_panel = new JPanel();
		option_panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(option_panel_image.getImage(), 0, 0, null);
			}
		};
		
		muzi_label = new JLabel(muzi_image); //300 X 284
		
		option_panel.setLayout(null);
		
		red_bt = new JButton(red_aim_image);
		orange_bt = new JButton(orange_aim_image);
		yellow_bt = new JButton(yellow_aim_image);
		green_bt = new JButton(green_aim_image);
		blue_bt = new JButton(blue_aim_image);
		
		red_bt.setBackground(Color.white);
		orange_bt.setBackground(Color.white);
		yellow_bt.setBackground(Color.white);
		green_bt.setBackground(Color.white);
		blue_bt.setBackground(Color.white);

		back_bt_3 = new JButton(back_bt_image); // ?????? ??? ????????????
		
		red_bt.setBounds(370,350,100,100);
		orange_bt.setBounds(570,350,100,100);
		yellow_bt.setBounds(770,350,100,100);
		green_bt.setBounds(470,500,100,100);
		blue_bt.setBounds(670,500,100,100);
		back_bt_3.setBounds(1050, 15, 150, 80);
		muzi_label.setBounds(800,600,300,284);
		
		option_panel.add(red_bt);
		option_panel.add(yellow_bt);
		option_panel.add(orange_bt);
		option_panel.add(blue_bt);
		option_panel.add(green_bt);
		option_panel.add(back_bt_3);
		option_panel.add(muzi_label);

		////////////////////////////////////////////////////////////

		add(intro_panel);

		setVisible(true);

		start_bt.addActionListener(new TransActionListener());
		ranking_bt.addActionListener(new FunctionActionListener());
		exit_bt.addActionListener(new FunctionActionListener());
		option_bt.addActionListener(new TransActionListener());
		back_bt_1.addActionListener(new FunctionActionListener());
		back_bt_2.addActionListener(new FunctionActionListener());
		back_bt_2.addActionListener(new FunctionActionListener());
		back_bt_3.addActionListener(new FunctionActionListener());
		push_bt_1.addActionListener(new MyActionListener());
		push_bt_2.addActionListener(new MyActionListener());
		push_bt_3.addActionListener(new MyActionListener());
		red_bt.addActionListener(new FunctionActionListener());
		orange_bt.addActionListener(new FunctionActionListener());
		yellow_bt.addActionListener(new FunctionActionListener());
		green_bt.addActionListener(new FunctionActionListener());
		blue_bt.addActionListener(new FunctionActionListener());

		for (time = 30; tf; time--) {
			music_time++;
			if(music_time == 175) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(bgm_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				music_time = 0;
			}
			System.out.println("????????????: " + time);
			if (time == -1) { // -1 ??? ???????????? ???????????? ?????? ??????????????? ??????????????? ???????????? ??????????????? time==0 ????????? ???????????? ??????????????? 0?????? ?????? 1?????? ??????
								// ????????? ????????? ????????? ?????? ???????????? ???????????? ??????.
				time = 30;
			}

			if (result_print == 1) { // ????????? 0?????? ????????? ??????????????? ??????????????? ????????? ???????????? 1??? ???????????? ????????? ???????????? ???????????? ??? ????????? ???????????? ?????? 0?????? ?????????.
				if (time_label.getText().equals("????????????: 0")) {
					push_bt_1.setVisible(false);
					push_bt_2.setVisible(false);
					push_bt_3.setVisible(false);
					student_info[next_user][0] = JOptionPane
							.showInputDialog("[??????: " + score + "???]   ????????? ????????? ?????????????????? ex) 1??????1???=?????????"); // ?????? ???????????? ????????? ?????????
																										// ?????? ????????? ?????????
																										// 0?????? ????????? ??????
					student_info[next_user][1] = Integer.toString(score);

					for (int k = 0; k < student_info.length; k++) { // ?????? ???????????? ??????????????? ??????
						System.out.println(student_info[k][0] + "," + student_info[k][1]);
					}

					for (int k = 0; k < student_info.length; k++) { // ???????????? ?????? ??????
						for (int z = 0; z < student_info.length - 1; z++) {
							if (Integer.parseInt(student_info[z][1]) < Integer.parseInt(student_info[z + 1][1])) {
								String score_temp = student_info[z][1];
								student_info[z][1] = student_info[z + 1][1];
								student_info[z + 1][1] = score_temp;

								String name_temp = student_info[z][0];
								student_info[z][0] = student_info[z + 1][0];
								student_info[z + 1][0] = name_temp;
							}
						}
					}

					System.out.println("\n");

					for (int k = 0; k < student_info.length; k++) { // ?????????????????? ????????? ????????? ?????? ??????
						System.out.println(student_info[k][0] + "," + student_info[k][1]);
					}
					eye_fake = 1;
					result_print = 0; // ?????? ???????????? ????????? ?????????????????? 0?????? ?????????
					next_user++; // ?????????????????? ???????????? ?????? ?????? ??????
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				System.exit(0); // ???????????? ????????????
			}

			if (eye_fake == 1) {
				time_label.setText("????????????: 0");
			} else {
				time_label.setText("????????????: " + time);
			}
		}	
	}

	class TransActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == start_bt) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(page_skip_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				
				result_print = 1;

				intro_panel.setVisible(false);
				add(game_panel);
				game_panel.setVisible(true);
				push_bt_1.setVisible(true);
				push_bt_2.setVisible(true);
				push_bt_3.setVisible(true);
				time = 30; // ?????? ????????? ?????? 30??? ??????
				score = 0; // ????????? ????????? ?????? ?????????
				score_label.setText("??????: " + Integer.toString(score));
			} else if (e.getSource() == option_bt) {	
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(page_skip_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {
					
				}
				intro_panel.setVisible(false);
				add(option_panel);
				option_panel.setVisible(true); ///////////////////////////////////////////////////////
			}
		}
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == push_bt_1) {

				System.out.println(tik_file.exists()); // true

				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(tik_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}

				score_label.setText("??????: " + Integer.toString(++score));
				random_x_one = (int) (Math.random() * 1141 + 60);
				random_y_one = (int) (Math.random() * 701 + 100);
				try {
					Thread.sleep(random_time_one);
					random_time_one = (int) (Math.random() * 291 + 10);
				} catch (InterruptedException e1) {
					System.exit(0); // ???????????? ????????????
				}
				push_bt_1.setBounds(random_x_one, random_y_one, 50, 50);
			} else if (e.getSource() == push_bt_2) {

				System.out.println(tik_file.exists()); // true

				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(tik_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}

				score_label.setText("??????: " + Integer.toString(++score));
				random_x_two = (int) (Math.random() * 1141 + 60);
				random_y_two = (int) (Math.random() * 701 + 100);
				try {
					Thread.sleep(random_time_two);
					random_time_two = (int) (Math.random() * 291 + 10);
				} catch (InterruptedException e1) {
					System.exit(0); // ???????????? ????????????
				}
				push_bt_2.setBounds(random_x_two, random_y_two, 50, 50);
			} else if (e.getSource() == push_bt_3) {

				System.out.println(tik_file.exists()); // true

				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(tik_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}

				score_label.setText("??????: " + Integer.toString(++score));
				random_x_three = (int) (Math.random() * 1141 + 60);
				random_y_three = (int) (Math.random() * 701 + 100);
				try {
					Thread.sleep(random_time_three);
					random_time_three = (int) (Math.random() * 291 + 10);
				} catch (InterruptedException e1) {
					System.exit(0); // ???????????? ????????????
				}
				push_bt_3.setBounds(random_x_three, random_y_three, 50, 50);
			}
		}
	}

	class FunctionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == exit_bt) {
				System.exit(0);
			} else if (e.getSource() == ranking_bt) {

				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(page_skip_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}

				intro_panel.setVisible(false);

				ranking_panel = new JPanel() {
					public void paintComponent(Graphics g1) {
						g1.drawImage(ranking_intro_image.getImage(), 0, 0, null);
					}
				};
				ranking_panel.setLayout(null);

				user_1 = new JLabel(student_info[0][0] + "                           " + student_info[0][1]);
				user_2 = new JLabel(student_info[1][0] + "                           " + student_info[1][1]);
				user_3 = new JLabel(student_info[2][0] + "                           " + student_info[2][1]);
				user_4 = new JLabel(student_info[3][0] + "                           " + student_info[3][1]);
				user_5 = new JLabel(student_info[4][0] + "                           " + student_info[4][1]);
				user_6 = new JLabel(student_info[5][0] + "                           " + student_info[5][1]);
				user_7 = new JLabel(student_info[6][0] + "                           " + student_info[6][1]);
				user_8 = new JLabel(student_info[7][0] + "                           " + student_info[7][1]);
				user_9 = new JLabel(student_info[8][0] + "                           " + student_info[8][1]);
				user_10 = new JLabel(student_info[9][0] + "                           " + student_info[9][1]);

				user_1.setFont(new Font("Dialog", Font.BOLD, 40));
				user_2.setFont(new Font("Dialog", Font.BOLD, 40));
				user_3.setFont(new Font("Dialog", Font.BOLD, 40));
				user_4.setFont(new Font("Dialog", Font.BOLD, 40));
				user_5.setFont(new Font("Dialog", Font.BOLD, 40));
				user_6.setFont(new Font("Dialog", Font.BOLD, 40));
				user_7.setFont(new Font("Dialog", Font.BOLD, 40));
				user_8.setFont(new Font("Dialog", Font.BOLD, 40));
				user_9.setFont(new Font("Dialog", Font.BOLD, 40));
				user_10.setFont(new Font("Dialog", Font.BOLD, 40));

				user_1.setBounds(223, 135, 1000, 50);
				user_2.setBounds(223, 225, 1000, 50);
				user_3.setBounds(223, 305, 1000, 50);
				user_4.setBounds(223, 390, 1000, 50);
				user_5.setBounds(223, 475, 1000, 50);
				user_6.setBounds(223, 560, 1000, 50);
				user_7.setBounds(223, 647, 1000, 50);
				user_8.setBounds(223, 732, 1000, 50);
				user_9.setBounds(223, 820, 1000, 50);
				user_10.setBounds(223, 905, 1000, 50);

				ranking_panel.add(user_1);
				ranking_panel.add(user_2);
				ranking_panel.add(user_3);
				ranking_panel.add(user_4);
				ranking_panel.add(user_5);
				ranking_panel.add(user_6);
				ranking_panel.add(user_7);
				ranking_panel.add(user_8);
				ranking_panel.add(user_9);
				ranking_panel.add(user_10);

				ranking_panel.add(back_bt_2);

				add(ranking_panel);

				ranking_panel.setVisible(true);
			} else if (e.getSource() == back_bt_1) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(select_bt_sounds_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				game_panel.setVisible(false);
				intro_panel.setVisible(true);
				eye_fake = 0;
				result_print = 0;
			} else if (e.getSource() == back_bt_2) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(back_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				ranking_panel.setVisible(false);
				intro_panel.setVisible(true);
			} else if (e.getSource() == back_bt_3) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(back_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				option_panel.setVisible(false);
				intro_panel.setVisible(true);
			} else if (e.getSource() == red_bt) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(select_bt_sounds_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				
				game_panel = new JPanel();
				game_panel = new JPanel() {
					public void paintComponent(Graphics g) {
						g.drawImage(game_panel_image.getImage(), 0, 0, null);
					}
				};
				game_panel.setLayout(null);

				push_bt_1 = new JButton(red_aim_image);
				push_bt_2 = new JButton(red_aim_image);
				push_bt_3 = new JButton(red_aim_image);
				
				random_x_one = (int) (Math.random() * 1141 + 60);
				random_y_one = (int) (Math.random() * 701 + 100);
				random_x_two = (int) (Math.random() * 1141 + 60);
				random_y_two = (int) (Math.random() * 701 + 100);
				random_x_three = (int) (Math.random() * 1141 + 60);
				random_y_three = (int) (Math.random() * 701 + 100);

				push_bt_1.setBounds(random_x_one, random_y_one, 50, 50);
				push_bt_2.setBounds(random_x_two, random_y_two, 50, 50);
				push_bt_3.setBounds(random_x_three, random_y_three, 50, 50);
				push_bt_1.setBorderPainted(false);
				push_bt_2.setBorderPainted(false);
				push_bt_3.setBorderPainted(false);
				score_label.setBounds(300, -200, 500, 500);
				time_label.setBounds(600, -200, 500, 500);

				game_panel.add(back_bt_1);
				game_panel.add(push_bt_1);
				game_panel.add(push_bt_2);
				game_panel.add(push_bt_3);
				game_panel.add(score_label);
				game_panel.add(time_label);

				compoundingListener();
			} else if (e.getSource() == orange_bt) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(select_bt_sounds_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				
				game_panel = new JPanel();
				game_panel = new JPanel() {
					public void paintComponent(Graphics g) {
						g.drawImage(game_panel_image.getImage(), 0, 0, null);
					}
				};
				game_panel.setLayout(null);

				score_label = new JLabel("??????: 0");
				score_label.setFont(new Font("Dialog", Font.BOLD, 40));
				time_label = new JLabel("????????????: 30");
				time_label.setFont(new Font("Dialog", Font.BOLD, 40));

				push_bt_1 = new JButton(orange_aim_image);
				push_bt_2 = new JButton(orange_aim_image);
				push_bt_3 = new JButton(orange_aim_image);
				
				random_x_one = (int) (Math.random() * 1141 + 60);
				random_y_one = (int) (Math.random() * 701 + 100);
				random_x_two = (int) (Math.random() * 1141 + 60);
				random_y_two = (int) (Math.random() * 701 + 100);
				random_x_three = (int) (Math.random() * 1141 + 60);
				random_y_three = (int) (Math.random() * 701 + 100);

				push_bt_1.setBounds(random_x_one, random_y_one, 50, 50);
				push_bt_2.setBounds(random_x_two, random_y_two, 50, 50);
				push_bt_3.setBounds(random_x_three, random_y_three, 50, 50);
				push_bt_1.setBorderPainted(false);
				push_bt_2.setBorderPainted(false);
				push_bt_3.setBorderPainted(false);
				score_label.setBounds(300, -200, 500, 500);
				time_label.setBounds(600, -200, 500, 500);

				game_panel.add(back_bt_1);
				game_panel.add(push_bt_1);
				game_panel.add(push_bt_2);
				game_panel.add(push_bt_3);
				game_panel.add(score_label);
				game_panel.add(time_label);
				
				compoundingListener();	
			} else if (e.getSource() == yellow_bt) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(select_bt_sounds_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				
				game_panel = new JPanel();
				game_panel = new JPanel() {
					public void paintComponent(Graphics g) {
						g.drawImage(game_panel_image.getImage(), 0, 0, null);
					}
				};
				game_panel.setLayout(null);

				score_label = new JLabel("??????: 0");
				score_label.setFont(new Font("Dialog", Font.BOLD, 40));
				time_label = new JLabel("????????????: 30");
				time_label.setFont(new Font("Dialog", Font.BOLD, 40));

				push_bt_1 = new JButton(yellow_aim_image);
				push_bt_2 = new JButton(yellow_aim_image);
				push_bt_3 = new JButton(yellow_aim_image);
				
				random_x_one = (int) (Math.random() * 1141 + 60);
				random_y_one = (int) (Math.random() * 701 + 100);
				random_x_two = (int) (Math.random() * 1141 + 60);
				random_y_two = (int) (Math.random() * 701 + 100);
				random_x_three = (int) (Math.random() * 1141 + 60);
				random_y_three = (int) (Math.random() * 701 + 100);

				push_bt_1.setBounds(random_x_one, random_y_one, 50, 50);
				push_bt_2.setBounds(random_x_two, random_y_two, 50, 50);
				push_bt_3.setBounds(random_x_three, random_y_three, 50, 50);
				push_bt_1.setBorderPainted(false);
				push_bt_2.setBorderPainted(false);
				push_bt_3.setBorderPainted(false);
				score_label.setBounds(300, -200, 500, 500);
				time_label.setBounds(600, -200, 500, 500);

				game_panel.add(back_bt_1);
				game_panel.add(push_bt_1);
				game_panel.add(push_bt_2);
				game_panel.add(push_bt_3);
				game_panel.add(score_label);
				game_panel.add(time_label);
				
				compoundingListener();		
			} else if (e.getSource() == green_bt) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(select_bt_sounds_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				
				game_panel = new JPanel();
				game_panel = new JPanel() {
					public void paintComponent(Graphics g) {
						g.drawImage(game_panel_image.getImage(), 0, 0, null);
					}
				};
				game_panel.setLayout(null);

				score_label = new JLabel("??????: 0");
				score_label.setFont(new Font("Dialog", Font.BOLD, 40));
				time_label = new JLabel("????????????: 30");
				time_label.setFont(new Font("Dialog", Font.BOLD, 40));

				push_bt_1 = new JButton(green_aim_image);
				push_bt_2 = new JButton(green_aim_image);
				push_bt_3 = new JButton(green_aim_image);
				
				random_x_one = (int) (Math.random() * 1141 + 60);
				random_y_one = (int) (Math.random() * 701 + 100);
				random_x_two = (int) (Math.random() * 1141 + 60);
				random_y_two = (int) (Math.random() * 701 + 100);
				random_x_three = (int) (Math.random() * 1141 + 60);
				random_y_three = (int) (Math.random() * 701 + 100);

				push_bt_1.setBounds(random_x_one, random_y_one, 50, 50);
				push_bt_2.setBounds(random_x_two, random_y_two, 50, 50);
				push_bt_3.setBounds(random_x_three, random_y_three, 50, 50);
				push_bt_1.setBorderPainted(false);
				push_bt_2.setBorderPainted(false);
				push_bt_3.setBorderPainted(false);
				score_label.setBounds(300, -200, 500, 500);
				time_label.setBounds(600, -200, 500, 500);

				game_panel.add(back_bt_1);
				game_panel.add(push_bt_1);
				game_panel.add(push_bt_2);
				game_panel.add(push_bt_3);
				game_panel.add(score_label);
				game_panel.add(time_label);
				
				compoundingListener();			
			} else if (e.getSource() == blue_bt) {
				try { // ?????? ??????
					AudioInputStream stream = AudioSystem.getAudioInputStream(select_bt_sounds_file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

				} catch (Exception e2) {

					e2.printStackTrace();
				}
				
				game_panel = new JPanel();
				game_panel = new JPanel() {
					public void paintComponent(Graphics g) {
						g.drawImage(game_panel_image.getImage(), 0, 0, null);
					}
				};
				game_panel.setLayout(null);

				score_label = new JLabel("??????: 0");
				score_label.setFont(new Font("Dialog", Font.BOLD, 40));
				time_label = new JLabel("????????????: 30");
				time_label.setFont(new Font("Dialog", Font.BOLD, 40));

				push_bt_1 = new JButton(blue_aim_image);
				push_bt_2 = new JButton(blue_aim_image);
				push_bt_3 = new JButton(blue_aim_image);
				
				random_x_one = (int) (Math.random() * 1141 + 60);
				random_y_one = (int) (Math.random() * 701 + 100);
				random_x_two = (int) (Math.random() * 1141 + 60);
				random_y_two = (int) (Math.random() * 701 + 100);
				random_x_three = (int) (Math.random() * 1141 + 60);
				random_y_three = (int) (Math.random() * 701 + 100);

				push_bt_1.setBounds(random_x_one, random_y_one, 50, 50);
				push_bt_2.setBounds(random_x_two, random_y_two, 50, 50);
				push_bt_3.setBounds(random_x_three, random_y_three, 50, 50);
				push_bt_1.setBorderPainted(false);
				push_bt_2.setBorderPainted(false);
				push_bt_3.setBorderPainted(false);
				score_label.setBounds(300, -200, 500, 500);
				time_label.setBounds(600, -200, 500, 500);

				game_panel.add(back_bt_1);
				game_panel.add(push_bt_1);
				game_panel.add(push_bt_2);
				game_panel.add(push_bt_3);
				game_panel.add(score_label);
				game_panel.add(time_label);
				
				compoundingListener();		
			}
		}
		public void compoundingListener() {		
			push_bt_1.addActionListener(new MyActionListener());
			push_bt_2.addActionListener(new MyActionListener());
			push_bt_3.addActionListener(new MyActionListener());
		}
	}

	public static void main(String[] args) {
		new Your_aim();
	}
}
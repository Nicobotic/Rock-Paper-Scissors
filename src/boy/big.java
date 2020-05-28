package boy;
import java.util.Random;
import boy.Msg;

public class big {
	 	//instance variables
		public static final String ROCK = "Rock";
		public static final String PAPER = "Paper";
		public static final String SCISSORS = "Scissors";
		public static final String EXIT = "Exit";
		
		/**
		 * method that gets the game Result
		 * */
		public static int getResult(String usersMove, String computersMove, int cnt1, int cnt2) {
		
	 
	        if (usersMove.equals(computersMove)) {
		        Msg.msg("It's a tie!");
		        return 0;
	        }
	        else if (usersMove.equals(ROCK)) 
	        {
		        if (computersMove.equals(SCISSORS)) {
			        Msg.msg("Rock beats scissors!");
			        return 1;
		        }
		        else if (computersMove.equals(PAPER)) {
			        Msg.msg("Paper beats rock!");
			        return 2;
		        }    
	        } 
	        else if (usersMove.equals(PAPER)) 
	        {
	            if (computersMove.equals(ROCK)) {
			        Msg.msg("Paper beats rock!");
			        return 1;
	            }
		        else if (computersMove.equals(SCISSORS)) {
			        Msg.msg("Scissor beats paper!");
			        return 2;
		        }
	        } 
	        else if (usersMove.equals(SCISSORS)) 
	        {
		        if (computersMove.equals(PAPER)) {
			        Msg.msg("Scissor beats paper!");
		        	return 1;
		        }
		        else if (computersMove.equals(ROCK)) {
			        Msg.msg("Rock beats scissors!");
		        	return 2;
		        }
	        } 
	    	return 0;
	    }
		/**
		 * method that get's the computer's move
		 * */
	public static String getComputersMove(){
			int computersNum;
			String computersMove="";
			Random random = new Random();
			computersNum = random.nextInt(3) + 1;
			if (computersNum == 1)
				computersMove = ROCK;
			else if (computersNum == 2)
				computersMove = PAPER;
			else if (computersNum == 3)
				computersMove = SCISSORS;
			
			return computersMove;
		}
		/**
		 * method that get's the user's move
		 * */
		
		public static String getUsersMove(int cnt, int cnt2, int options){
		    String inputo = "";
		    int input = 4;
		    if(options == 0) {
				input = Msg.option(new String[] {ROCK, PAPER, SCISSORS, EXIT},"Player 1 Score: " + cnt + "\nPlayer 2 Score: " + cnt2 + "\nEnter your play: ");
			}
		    if (options == 1) {
		    	input = Msg.option(new String[] {ROCK, PAPER, SCISSORS, EXIT},"Player Score: " + cnt + "\nComputer Score: " + cnt2 + "\nEnter your play: ");
		    }
		    if (input == 0) {
		    	inputo = ROCK;
		    }
		    if (input == 1) {
		    	inputo = PAPER;
		    }
		    if(input == 2) {
		    	inputo = SCISSORS;
		    }
		    if(input == 3) {
		    	System.exit(0);
		    }
	        return inputo;
	    }
		
	    /**
	     * Main method
	     * */	
		public static void main(String[] args) {
			int result;
			int high = 0;
			int total = 0;
			boolean playing = true;
			Msg.msg( "Welcome to Rock, Paper, Scissors!");
			int options = Msg.option(new String[] {"Player vs Player","Player vs Computer", "Exit"}, "Choose mode:");
			if (options == 0) {
				boolean done = false;
				int cnt = 0;
				int cnt2 = 0;
				int high2 = 0;
				while (playing) {
					while (done != true) {
						String user1 = getUsersMove(cnt, cnt2, options);
						String user2 = getUsersMove(cnt, cnt2, options);
						Msg.msg("Player 1: " + user1 + "\n" + "Player 2: " + user2);
						result = getResult(user1, user2, cnt, cnt2);
						if(result == 1) {
							cnt++;
						}
						else if(result == 2) {
							cnt2++;
						}
						else {
			
						}
						if(cnt == 3) {
							Msg.msg("Player 1 Wins.");
							done = true;
							total++;
							high++;
						}
						else if(cnt2 == 3) {
							Msg.msg("Player 2 Wins.");
							done = true;
							total++;
							high2++;
						}
					}
					if(Msg.option(new String[] {"Yes", "No"}, "Would you like to play again?\n" + "Player 1 has won: " + high + "\nPlayer 2 has won: " + high2 +"\nTotal games played: " + total) == 0) {
						done = false;
						cnt = 0;
						cnt2 = 0;
					}
					else {
						Msg.msg("Thanks for playing!");
						playing = false;
					}
					}
				}
			if (options == 1) {
				boolean done = false;
				int cnt = 0;
				int cnt2 = 0;
				while (playing) {
					while (done != true) {
						if(cnt != 3 && cnt2 != 3) {
							String userInput = getUsersMove(cnt, cnt2, options); 
							String computerInput = getComputersMove();
							Msg.msg("Player: " + userInput + "\n" + "Computer: " + computerInput);
							result = getResult(userInput, computerInput, cnt, cnt2);
							if(result == 1) {
								cnt++;
							}
							else if(result == 2) {
								cnt2++;
							}
							else {
							
							}
						}
						if(cnt == 3) {
							Msg.msg("You beat the computer!");
							done = true;
							high++;
							total++;
						}
						else if(cnt2 == 3) {
							Msg.msg("You lost against the computer. What a shame..");
							done = true;
							total++;
						}
					}
				if(Msg.option(new String[] {"Yes", "No"}, "Would you like to play again?\n" + "Your highscore is " + high + " out of " + total +" games played.") == 0) {
					done = false;
					cnt = 0;
					cnt2 = 0;	
				}
				else {
					Msg.msg("Thank you for playing!");
					playing = false;
				}
				}
			}
			if(options == 3) {
			
			}
		}
	}

import java.util.Scanner;
import java.sql.*;

/***
 * Michael Dorfman
 * Lab 17
 * CP450 - OOP Java
 * 01/01/2018
 */

public class TeamDB
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:sqlserver://cc-cpserver.confederationc.on.ca\\CPTM;databaseName=TeamDB_03;user=student;password=student;" + "create=true";
      Connection conn;
      try
      {
         // Create a connection to the database
         conn = DriverManager.getConnection(DB_URL);

         char choice;
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Welcome to the Sports " +
                            "Teams Database Manager!");
         do
         {
            printMenu();
            choice = keyboard.nextLine().charAt(0);
            switch(choice)
            {
               case '0':
                  // Close the connection
                  conn.close();
                  break;
               case '1':
                  viewTeams(conn);
                  break;
               case '2':
                  viewSchedule(conn);
                  break;
               case '3':
                  addTeams(conn);
                  break;
               case '4':
                  addGames(conn);
                  break;
               case '5':
                  enterScores(conn);
                  break;
               case '6':
                  beginNewSeason(conn);
                  break;
            }
         } while(choice != '0');
      }

      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /***
    * printMenu Method
    * This method prints out a menu for the user to select items from
    * to interact with the program
    */
   public static void printMenu()
   {
      System.out.println();
      System.out.println("Select from the following " +
                         "options:");
      System.out.println("1. View team standings");
      System.out.println("2. View the schedule");
      System.out.println("3. Add a team");
      System.out.println("4. Add a game to the schedule");
      System.out.println("5. Enter game scores");
      System.out.println("6. Begin a new season");
      System.out.println("0. Exit the program");
   }

   /***
    * beginNewSeason Method
    * This method begins a new season by resetting the database
    * to its initial state
    * @param conn Database Connection
    */
   public static void beginNewSeason(Connection conn)
   {
      try
      {
         Statement stmt = conn.createStatement();

         // Remove the tables if they already exist
         // Throws an exception if the tables do not exist
         stmt.execute("DROP TABLE Games");
         stmt.execute("DROP TABLE Teams");

         // Once the tables have been removed, call the
         // method to create and initialize the tables
         System.out.println("Reinitializing database " +
                            "for a new season");
         createTeamDB(conn);
      }

      catch(Exception ex)
      {
         // Create the tables if they do not exist
         System.out.println("Creating database for " +
                            "the first time");
         createTeamDB(conn);
      }
   }

   /***
    * createTeamDB Method
    * This method inserts default values into the newly reset
    * database for first use.
    * @param conn Database Connection
    */
   public static void createTeamDB(Connection conn)
   {
      try
      {
         Statement stmt = conn.createStatement();

         // Create the table of teams
         stmt.execute("CREATE TABLE Teams (" +
                      "TeamName CHAR(15) " +
                      "NOT NULL PRIMARY KEY, " +
                      "Wins INT, " + "Losses INT, " +
                      "Ties INT" + ")");

         // Add some teams
         stmt.executeUpdate("INSERT INTO Teams " +
                            "(TeamName) " +
                            "VALUES ('Astros')");

         stmt.executeUpdate("INSERT INTO Teams " +
                            "(TeamName) " +
                            "VALUES ('Marlins')");

         stmt.executeUpdate("INSERT INTO Teams " +
                            "(TeamName) " +
                            "VALUES ('Brewers')");

         stmt.executeUpdate("INSERT INTO Teams " +
                            "(TeamName) " +
                            "VALUES ('Cubs')");

         // Create a listing of the games to be played
         stmt.execute("CREATE TABLE Games (" +
                      "GameNumber INT " +
                      "NOT NULL PRIMARY KEY, " +
                      "HomeTeam CHAR(15) " +
                      "NOT NULL REFERENCES " +
                      "Teams (TeamName), " +
                      "HomeTeamScore INT, " +
                      "VisitorTeam CHAR(15) NOT NULL " +
                      "REFERENCES Teams (TeamName), " +
                      "VisitorTeamScore INT" + ")");

         stmt.executeUpdate("INSERT INTO Games " +
                            "(GameNumber, HomeTeam, " +
                            "VisitorTeam) " +
                            "VALUES (1, 'Astros', " +
                            "'Brewers')");

         stmt.executeUpdate("INSERT INTO Games " +
                            "(GameNumber, HomeTeam, " +
                            "VisitorTeam) " +
                            "VALUES (2, 'Brewers', " +
                            "'Cubs')");

         stmt.executeUpdate("INSERT INTO Games " +
                            "(GameNumber, HomeTeam, " +
                            "VisitorTeam) " +
                            "VALUES (3, 'Cubs', " +
                            "'Astros')");
      }

      catch (Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /***
    * addTeams Method
    * This method is used to add teams to the database
    * @param conn Database Connection
    */
   public static void addTeams(Connection conn)
   {
      Scanner keyboard = new Scanner(System.in);
      try
      {
         char ans;
         String teamName;
         Statement stmt = conn.createStatement();
         do
         {
             System.out.print("Enter the team name: ");
             teamName = keyboard.nextLine();
             String SQLS = "INSERT INTO Teams " + "(TeamName) " + "VALUES ('" + teamName + "')";
             stmt.executeUpdate(SQLS);
            System.out.print("Do you want to enter another team: ");
            ans = keyboard.nextLine().charAt(0);
         } while(ans == 'Y'|| ans == 'y');
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /***
    * addGames Method
    * This method is used to add games to the database
    * @param conn Database Connection
    */
   public static void addGames(Connection conn)
   {
      Scanner keyboard = new Scanner (System.in);
      try
      {
         char ans;
         String homeTeam;
         String visitingTeam;
         int gameNumber = 1;
         Statement stmt = conn.createStatement();
         ResultSet result = stmt.executeQuery("SELECT * " + "FROM " + "Games");
         while(result.next())
         {
            gameNumber++;
         }
         do
         {
            System.out.print("Enter the home team name: ");
            homeTeam = keyboard.nextLine();
            System.out.print("Enter the visiting team name: ");
            visitingTeam = keyboard.nextLine();
            stmt.executeUpdate("INSERT INTO Games " + "(GameNumber, HomeTeam, " + "VisitorTeam) " + "VALUES (" + gameNumber + ", '" + homeTeam + "', '" + visitingTeam + "')");
            System.out.print("Do you want to enter another game: ");
            ans = keyboard.nextLine().charAt(0);
         } while(ans == 'Y'|| ans == 'y');
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /***
    * viewTeams Method
    * This method is used to view the teams and their stats
    * from the database
    * @param conn Database Connection
    */
   public static void viewTeams(Connection conn)
   {
      try
      {
         Statement stmt = conn.createStatement();
         ResultSet result = stmt.executeQuery("SELECT * " + "FROM " + "Teams");
         System.out.printf("%-15s %10s %10s %10s\n", "Team Name", "Win", "Lose", "Tie");
         while(result.next())
         {
            System.out.printf("%-15s %10d %10d %10d\n",
                              result.getString("TeamName"),
                              result.getInt("Wins"),
                              result.getInt("Losses"),
                              result.getInt("Ties"));
         }
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /***
    * viewSchedule Method
    * This method displays a list of games and scores
    * from the database
    * @param conn Database Connection
    */
   public static void viewSchedule(Connection conn)
   {
      try
      {
         Statement stmt = conn.createStatement();
         String SQLS = "SELECT * FROM Games";
         ResultSet SQLR = stmt.executeQuery(SQLS);
         System.out.println("List of games and scores:");
         System.out.printf("%-6s %-20s %6s" + "%-20s %6s\n", "GameID", "Home", "Score", "Visitor", "Score");
          while(SQLR.next())
          {
              System.out.printf("%-6d %-20s %6d %-20s %6d\n",
                      SQLR.getInt("GameNumber"),
                      SQLR.getString("HomeTeam"),
                      SQLR.getInt("HomeTeamScore"),
                      SQLR.getString("VisitorTeam"),
                      SQLR.getInt("VisitorTeamScore"));
          }
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /***
    * enterScores Method
    * This method allows the user to enter scores into the
    * database
    * @param conn Database Connection
    */
   public static void enterScores(Connection conn)
   {
      Scanner keyboard = new Scanner(System.in);
      try
      {
         char ans;
         int gameNumber;
         String homeTeam;
         String visitingTeam;
         int score1;
         int score2;
         String sqlStatement;
         ResultSet result = null;
         Statement stmt = conn.createStatement();
         do
         {
            viewSchedule(conn);
            System.out.print("Enter the game ID: ");
            gameNumber = keyboard.nextInt();
             result = stmt.executeQuery("SELECT * FROM Games WHERE GameNumber = " + gameNumber);
            if(result.next())
            {
               homeTeam = result.getString("HomeTeam");
               visitingTeam = result.getString("VisitorTeam");
               System.out.print("Enter the score for the " + homeTeam);
               score1 = keyboard.nextInt();
               System.out.print("Enter the score for the " + visitingTeam);
               score2 = keyboard.nextInt();
               keyboard.nextLine();
               stmt.executeUpdate("UPDATE Games SET HomeTeamScore = " + score1 + " WHERE GameNumber = " + gameNumber);
               stmt.executeUpdate("UPDATE Games SET VisitorTeamScore = " + score2 + " WHERE GameNumber = " + gameNumber);
               if(score1 < score2)
               {
                   result = stmt.executeQuery("SELECT Losses FROM Teams " + " WHERE TeamName = " + "'" + homeTeam + "'");
                   if(result.next())
                   {
                        int losses = result.getInt("Losses");
                        stmt.executeUpdate("UPDATE Teams " + "SET Losses = " + (losses + 1) + " WHERE TeamName = " + "'" + homeTeam + "'");
                   }
                   result = stmt.executeQuery("SELECT Wins FROM Teams " + " WHERE TeamName = " + "'" + visitingTeam + "'");
                   if(result.next())
                   {
                       int wins = result.getInt("Wins");
                       stmt.executeUpdate("UPDATE Teams " + "SET Wins = " + (wins + 1) + " WHERE TeamName = " + "'" + visitingTeam + "'");
                   }
               }
               else if(score2 < score1)
               {
                   result = stmt.executeQuery("SELECT Losses FROM Teams " +" WHERE TeamName = " + "'" + visitingTeam + "'");
                   if (result.next())
                   {
                       int losses = result.getInt("Losses");
                       stmt.executeUpdate("UPDATE Teams " + "SET Losses = " + (losses+1) +" WHERE TeamName = " + "'" + visitingTeam + "'");
                   }
                   result = stmt.executeQuery("SELECT Wins FROM Teams " +" WHERE TeamName = " + "'" + homeTeam + "'");
                   if (result.next())
                   {
                       int wins = result.getInt("Wins");
                       stmt.executeUpdate("UPDATE Teams " + "SET Wins = " + (wins+1) +" WHERE TeamName = " + "'" + homeTeam + "'");
                   }
               }
               else
               {
                   int ties;
                   result = stmt.executeQuery("SELECT Ties FROM Teams " + " WHERE TeamName = " + "'" + homeTeam + "'");
                   if (result.next())
                   {
                       ties = result.getInt("Ties");
                       stmt.executeUpdate("UPDATE Teams " + "SET Ties = " + (ties+1) + " WHERE TeamName = " + "'" + homeTeam + "'");
                   }
                   result = stmt.executeQuery("SELECT Ties FROM Teams " + " WHERE TeamName = " + "'" + visitingTeam + "'");
                   if(result.next())
                   {
                       ties = result.getInt("Ties");
                       stmt.executeUpdate("UPDATE Teams " + "SET Ties = " + (ties+1) + " WHERE TeamName = " + "'" + visitingTeam + "'");
                   }
               }
            }

            System.out.print("Do you want to enter another game: ");
            ans = keyboard.nextLine().charAt(0);

         } while(ans == 'Y'|| ans == 'y');
      }

      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}

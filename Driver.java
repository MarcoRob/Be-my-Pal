import java.util.ArrayList;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Queue.UnboundedQueueInterface;

public class Driver {

	public static void main(String[] args) {

		HashTable hash = new HashTable(100);

		Graph<User> graphUsers = new Graph<>(100);
		Graph<String> graphInterests = new Graph<>(100);

		ArrayList<User> userList = new ArrayList<>();

		User user1 = new User("hector", "12", "Hector", "Hurtado", "d", 1);
		User user2 = new User("marco", "12", "Marco", "Robles", "d", 1);
		User user3 = new User("pepe", "12", "Pepe", "Fi", "d", 1);
		User user4 = new User("beto", "12", "m", "m", "d", 1);

		graphUsers.addVertex(user1);
		graphUsers.addVertex(user2);
		graphUsers.addVertex(user3);
		graphUsers.addVertex(user4);

		hash.insert(user1.getUsername());
		hash.insert(user2.getUsername());
		hash.insert(user3.getUsername());
		hash.insert(user4.getUsername());

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);

		graphInterests.addVertex(user1.getUsername());
		graphInterests.addVertex(user2.getUsername());
		graphInterests.addVertex(user3.getUsername());
		graphInterests.addVertex(user4.getUsername());
		graphInterests.addVertex("Nadar");
		graphInterests.addVertex("Guitarra");
		graphInterests.addVertex("Futbol");
		graphInterests.addVertex("Gimnasio");

		graphInterests.addEdge(user1.getUsername(), "Guitarra", 1);
		graphInterests.addEdge(user2.getUsername(), "Guitarra", 1);
		graphInterests.addEdge(user3.getUsername(), "Guitarra", 1);
		graphInterests.addEdge(user1.getUsername(), "Nadar", 1);
		graphInterests.addEdge(user2.getUsername(), "Nadar", 1);
		graphInterests.addEdge(user3.getUsername(), "Nadar", 1);
		graphInterests.addEdge("Guitarra", user1.getUsername(),1);
		graphInterests.addEdge("Guitarra", user2.getUsername(),1);
		graphInterests.addEdge("Guitarra", user3.getUsername(),1);

		//TIEMPO long initTime = System.nanoTime();
		long initTime = System.nanoTime();
		//-----------------------

		boolean loop = true;
		do {
			try {
				
				int posicionadorDeTemp = 0;
				int ans = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Be-my-Pal "
						+ "\nWhat do you want to do? \n1) Sign Up \n2) Sign In\n3) Exit: \nAnswer (1, 2, 3): ")) ;
				//------------------------------Registarse ------------------------------------------------------//
				if(ans == 1){ 
					String user = JOptionPane.showInputDialog("Username: ");
					JPasswordField pf = new JPasswordField();
					int pass = JOptionPane.showConfirmDialog(null, pf, "Password: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					String password = "";
					if (pass == JOptionPane.OK_OPTION) {
						password = new String(pf.getPassword());
						System.err.println("You entered: " + password);
					}
					String name = JOptionPane.showInputDialog("First Name: ");
					String lastname = JOptionPane.showInputDialog("Last Name: ");
					String date = JOptionPane.showInputDialog("Birth Date : ");
					int interests = Integer.parseInt(JOptionPane.showInputDialog("How many interests or hobbies do you want to have \nin comun "
							+ "with your friends? (1,2, ... n) "));
					String myInterest = JOptionPane.showInputDialog("Write an interest or hobby");
					graphInterests.addVertex(myInterest);
					int gradeInterest = Integer.valueOf(JOptionPane.showInputDialog("Do you \n1- Love it\n2- Enjoy it\n3- Practice it?"));
					graphInterests.addEdge(user, myInterest, gradeInterest);
					graphInterests.addEdge(myInterest, user, gradeInterest);
					int confirm = JOptionPane.showConfirmDialog(null, "Do you want to add another interest or hobby?", null, JOptionPane.YES_NO_OPTION);
					while(confirm == 0) {
						myInterest = JOptionPane.showInputDialog("Write an interest or hobby");
						graphInterests.addVertex(myInterest);
						gradeInterest = Integer.valueOf(JOptionPane.showInputDialog("Do you \n1- Love it\n2- Enjoy it\n3- Practice it?"));
						graphInterests.addEdge(user, myInterest, gradeInterest);
						graphInterests.addEdge(myInterest, user, gradeInterest);
						confirm = JOptionPane.showConfirmDialog(null, "Do you want to add another interest or hobby?", null, JOptionPane.YES_NO_OPTION);
					}
					System.out.println(password);
					User newUser = new User(user, password, name, lastname, date, interests);
					userList.add(newUser);
					graphUsers.addVertex(newUser);//-----insert here the user node ----/
					hash.insert(user);
					System.out.println("HASH TABLE \n" + hash);
					JOptionPane.showMessageDialog(null, "Now you have been registered!\nNow you have to Sign In! ");
					//-----------------------------Iniciar sesion ----------------------------------------------------//
				} else if (ans == 2) {
					boolean exit = true;
					do {
						String username1 = JOptionPane.showInputDialog("Username: ");
						String passw = "";
						//---Password -- //
						JPasswordField pf1 = new JPasswordField();
						int pass = JOptionPane.showConfirmDialog(null, pf1, "Password: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
						if (pass == JOptionPane.OK_OPTION) {
							String password = new String(pf1.getPassword());
							passw = password;
						} 


						if(hash.search(username1)) {
							User temp = new User();
							for(int i = 0; i < userList.size(); i++){
								if(username1.equals(userList.get(i).getUsername())){
									temp = userList.get(i);
									posicionadorDeTemp = i;
									break;
								} 
							}
							if(passw.equals(temp.getPass())){
								boolean cualquiera = true;
								do {
									int option = Integer.parseInt(JOptionPane.showInputDialog("WELCOME " + temp.getFullName() + "\nYou are logged In \n "
											+ "What do you want to do?\n1) See my list of friends \n2) Find new friends\n3) Profile \n4) Edit Profile \n5) Log out"));
									if(option == 1){
										// Lista de amigos....
										String listaAmigos = "";
										for(int i = 0; i < userList.size(); i++) {
											if(graphUsers.breadthPath(temp, userList.get(i))
													&& !temp.getUsername().equals(userList.get(i).getUsername())) {
												listaAmigos = listaAmigos + userList.get(i).getFullName() + "\n";
											}
										}
										if(!listaAmigos.equals("")) {
											JOptionPane.showMessageDialog(null, "Your friends are:\n" + listaAmigos);
										}
										else {
											JOptionPane.showMessageDialog(null, "No friends yet   :'(");
										}
									} else if(option == 2){
										//Recomendar amigos
										int puntosAmistad = 0;
										int cantidadPasatiempos = temp.getInterests();
										String pasatiempo = JOptionPane.showInputDialog("Search for friends that like:\n");
										String listaRecomendaciones = "";
										String posicionGraphUsers = "";
										for(int i = 0; i < userList.size(); i++) {
											if(!graphUsers.breadthPath(temp, userList.get(i)) && !temp.getUsername().equals(userList.get(i).getUsername())) {
												if((graphInterests.breadthPath(temp.getUsername(), pasatiempo)
														&& graphInterests.breadthPath(userList.get(i).getUsername(), pasatiempo)) ||
														(graphInterests.breadthPath(pasatiempo, userList.get(i).getUsername())
																&& graphInterests.breadthPath(pasatiempo, temp.getUsername()))) {
													puntosAmistad++;
													if(puntosAmistad == cantidadPasatiempos) {
														posicionGraphUsers = posicionGraphUsers + i + ",";
														listaRecomendaciones = listaRecomendaciones + userList.get(i).getFullName() + "\n";
													}
												}
											}
											puntosAmistad = 0;
											/*if(graphInterests.getCounter() >= cantidadPasatiempos){
										puntosAmistad++;
										if(puntosAmistad == cantidadPasatiempos) {
											graphUsers.addEdge(temp, userList.get(i), 10);
											graphUsers.addEdge(userList.get(i), temp, 10);
											listaRecomendaciones += userList.get(i).getFullName() + "\n";
										}
									}*/
										}
										if(!listaRecomendaciones.equals("") || !posicionGraphUsers.equals("")) {
											JOptionPane.showMessageDialog(null, "We suggest you to be friend of:\n" + listaRecomendaciones);
											String[] arregloListaR = listaRecomendaciones.split("\n");
											String[] arregloGraphUsers = posicionGraphUsers.split(",");
											for(int i = 0; i < arregloListaR.length; i++) {
												int addFriend = JOptionPane.showConfirmDialog(null, "Do you want to add " + arregloListaR[i] + " as a friend?", null, JOptionPane.YES_NO_OPTION);
												if(addFriend == 0) {
													graphUsers.addEdge(temp, userList.get(Integer.parseInt(arregloGraphUsers[i])), 10);
													graphUsers.addEdge(userList.get(Integer.parseInt(arregloGraphUsers[i])), temp, 10);
												}
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "No friends on the list.");
										}
									}
									else if(option == 3) {
										JOptionPane.showMessageDialog(null, temp.toString());
									}
									else if(option == 4) {
										boolean editProfile = true;
										do {
											int edit = Integer.parseInt(JOptionPane.showInputDialog("Edit Profile \nWhat do you want to edit? "
													+ "\n1) First Name \n2) Last Name \n3) Date Birth \n4) Password \n5) Delete account\n6) Go back"));
											User temp2 = temp;
											switch (edit) {
											case 1:
												String name = JOptionPane.showInputDialog("First Name: ");
												temp.setName(name);
												break;
											case 2:
												String lastname = JOptionPane.showInputDialog("Last Name: ");
												temp.setLastname(lastname);
												break;
											case 3:
												String date = JOptionPane.showInputDialog("Birth Date: ");
												temp.setDate(date);
												break;
											case 4:
												String passwd = "";
												JPasswordField pf2 = new JPasswordField();
												int pass1 = JOptionPane.showConfirmDialog(null, pf2, "New Password: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
												if (pass1 == JOptionPane.OK_OPTION) {
													String password = new String(pf2.getPassword());
													passwd = password;
												}
												System.out.println(temp.getPass());
												System.out.println(passwd);
												temp.setPassw(passwd);
												break;
											case 5:
												// BORRAAAR
											default:
												int ans1 = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Warning", JOptionPane.YES_NO_OPTION);
												if(ans1 == 0){
													//copiar cambios
													userList.add(posicionadorDeTemp, temp);
													graphUsers.addVertex(temp, graphUsers.indexIs(temp2));
													System.out.println("Copiando cambios");
												}
												editProfile = false;
												break;
											} //switch end
										}
										while(editProfile);
									}
									else if(option == 5) { 
										cualquiera = false;
										exit = false;

									}
								}
								while(cualquiera);
							}
							else {
								JOptionPane.showMessageDialog(null, "It seems there is a problem with your password\nTry to write it again!");
							}

						} else {
							JOptionPane.showMessageDialog(null, "It seems there is a problem!\nIt is possible that you are not Registered\n Try it again!");
							exit = false;
						}
						
				
					} while(exit);
				} else {
					JOptionPane.showMessageDialog(null, "Be-my-Pal\nGoodbye");
					loop = false;
				}
					
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Be-my-Pal\nGoodbye");
				loop = false;
			}
			
		} while(loop);
	

		long estimateTime = (System.nanoTime() - initTime) / 1000000000 ;
		System.out.println(estimateTime + " sec");
	}
}
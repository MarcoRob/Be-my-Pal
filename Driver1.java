import java.util.ArrayList;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Queue.UnboundedQueueInterface;

public class Driver1 {

	public static void main(String[] args) {

		HashTable hash = new HashTable(100);
		HashTable hashIntersts = new HashTable(100);

		WeightedGraph<User> graphUsers = new WeightedGraph<>(100);
		WeightedGraph<String> graphInterests = new WeightedGraph<>(100);

		ArrayList<User> userList = new ArrayList<>();

		User user1 = new User("hector", "12", "Héctor", "Hurtado", "27/Jul/95", 1);
		User user2 = new User("marco", "12", "Marco", "Robles", "04/Sep/96", 1);
		User user3 = new User("pepe", "12", "José", "Hernández", "08/May/97", 1);
		User user4 = new User("santi", "12", "Santiago", "Perello", "06/May/16", 1);
		User user5 = new User("alfredo", "12", "Alfredo", "Rivera", "31/Ene/72", 1);
		User user6 = new User("beto", "12", "Alberto", "Gómez", "01/Feb/00", 1);
		User user7 = new User("maria", "12", "María", "Oliva", "29/Feb/04", 1);
		User user8 = new User("paco", "12", "Francisco", "Sandoval", "25/Dic/99", 1);
		User user9 = new User("elena", "12", "Elena", "Bayo", "17/Abr/88", 1);
		User user10 = new User("ana", "12", "Ana", "Salvatierra", "19/Jun/79", 1);
		User user11 = new User("silvia", "12", "Silvia", "Delgado", "07/Ago/60", 1);
		User user12 = new User("natalia", "12", "Natalia", "Revueltas", "07/Oct/67", 1);
		User user13 = new User("goyo", "12", "Gregorio", "Rodríguez", "02/Mar/91", 1);
		User user14 = new User("nacho", "12", "Ignacio", "Carrasco", "28/Jul/97", 1);
		User user15 = new User("chava", "12", "Salvador", "Vázquez", "26/May/93", 1);
		User user16 = new User("ruben", "12", "Rubén", "Palacios", "22/Abr/92", 1);
		User user17 = new User("esperanza", "12", "Esperanza", "Arcos", "21/Ene/84", 1);
		User user18 = new User("marisol", "12", "Marisol", "Leiva", "31/Dic/99", 1);
		User user19 = new User("angeles", "12", "Ángeles", "Tellez", "27/Ago/81", 1);
		User user20 = new User("josefina", "12", "Josefina", "Díaz", "30/Nov/86", 1);

		graphUsers.addVertex(user1);
		graphUsers.addVertex(user2);
		graphUsers.addVertex(user3);
		graphUsers.addVertex(user4);
		graphUsers.addVertex(user5);
		graphUsers.addVertex(user6);
		graphUsers.addVertex(user7);
		graphUsers.addVertex(user8);
		graphUsers.addVertex(user9);
		graphUsers.addVertex(user10);
		graphUsers.addVertex(user11);
		graphUsers.addVertex(user12);
		graphUsers.addVertex(user13);
		graphUsers.addVertex(user14);
		graphUsers.addVertex(user15);
		graphUsers.addVertex(user16);
		graphUsers.addVertex(user17);
		graphUsers.addVertex(user18);
		graphUsers.addVertex(user19);
		graphUsers.addVertex(user20);

		hash.insert(user1.getUsername());
		hash.insert(user2.getUsername());
		hash.insert(user3.getUsername());
		hash.insert(user4.getUsername());
		hash.insert(user5.getUsername());
		hash.insert(user6.getUsername());
		hash.insert(user7.getUsername());
		hash.insert(user8.getUsername());
		hash.insert(user9.getUsername());
		hash.insert(user10.getUsername());
		hash.insert(user11.getUsername());
		hash.insert(user12.getUsername());
		hash.insert(user13.getUsername());
		hash.insert(user14.getUsername());
		hash.insert(user15.getUsername());
		hash.insert(user16.getUsername());
		hash.insert(user17.getUsername());
		hash.insert(user18.getUsername());
		hash.insert(user19.getUsername());
		hash.insert(user20.getUsername());

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user8);
		userList.add(user9);
		userList.add(user10);
		userList.add(user11);
		userList.add(user12);
		userList.add(user13);
		userList.add(user14);
		userList.add(user15);
		userList.add(user16);
		userList.add(user17);
		userList.add(user18);
		userList.add(user19);
		userList.add(user20);

		graphInterests.addVertex(user1.getUsername());
		graphInterests.addVertex(user2.getUsername());
		graphInterests.addVertex(user3.getUsername());
		graphInterests.addVertex(user4.getUsername());
		graphInterests.addVertex(user5.getUsername());
		graphInterests.addVertex(user6.getUsername());
		graphInterests.addVertex(user7.getUsername());
		graphInterests.addVertex(user8.getUsername());
		graphInterests.addVertex(user9.getUsername());
		graphInterests.addVertex(user10.getUsername());
		graphInterests.addVertex(user11.getUsername());
		graphInterests.addVertex(user12.getUsername());
		graphInterests.addVertex(user13.getUsername());
		graphInterests.addVertex(user14.getUsername());
		graphInterests.addVertex(user15.getUsername());
		graphInterests.addVertex(user16.getUsername());
		graphInterests.addVertex(user17.getUsername());
		graphInterests.addVertex(user18.getUsername());
		graphInterests.addVertex(user19.getUsername());
		graphInterests.addVertex(user20.getUsername());
		hashIntersts.insert("Nadar");
		hashIntersts.insert("Guitarra");
		hashIntersts.insert("Futbol");
		hashIntersts.insert("Gimnasio");
		hashIntersts.insert("Dormir");
		hashIntersts.insert("Bailar");
		
		graphInterests.addVertex("Nadar");
		graphInterests.addVertex("Guitarra");
		graphInterests.addVertex("Futbol");
		graphInterests.addVertex("Gimnasio");
		graphInterests.addVertex("Amigos");
		graphInterests.addVertex("Cine");
		graphInterests.addVertex("Dormir");
		graphInterests.addVertex("Bailar");

		graphInterests.addEdge(user1.getUsername(), "Guitarra", 1);
		graphInterests.addEdge(user2.getUsername(), "Guitarra", 1);
		graphInterests.addEdge(user3.getUsername(), "Guitarra", 1);
		graphInterests.addEdge(user1.getUsername(), "Nadar", 1);
		graphInterests.addEdge(user2.getUsername(), "Nadar", 1);
		graphInterests.addEdge(user3.getUsername(), "Nadar", 1);
		graphInterests.addEdge(user4.getUsername(), "Dormir", 1);
		graphInterests.addEdge(user1.getUsername(), "Dormir", 1);
		graphInterests.addEdge(user3.getUsername(), "Guitarra", 1);
		graphInterests.addEdge(user5.getUsername(), "Nadar", 1);
		graphInterests.addEdge(user6.getUsername(), "Gimnasio", 1);
		graphInterests.addEdge(user6.getUsername(), "Guitarra", 1);
		graphInterests.addEdge(user7.getUsername(), "Cine", 1);
		graphInterests.addEdge(user8.getUsername(), "Cine", 1);
		graphInterests.addEdge(user9.getUsername(), "Cine", 1);
		graphInterests.addEdge(user7.getUsername(), "Nadar", 1);
		graphInterests.addEdge(user7.getUsername(), "Amigos", 1);
		graphInterests.addEdge(user8.getUsername(), "Dormir", 1);
		graphInterests.addEdge(user8.getUsername(), "Guitarra", 1);
		graphInterests.addEdge(user10.getUsername(), "Dormir", 1);
		graphInterests.addEdge(user10.getUsername(), "Bailar", 1);
		graphInterests.addEdge(user11.getUsername(), "Bailar", 1);
		graphInterests.addEdge(user12.getUsername(), "Gimnasio", 1);
		graphInterests.addEdge(user12.getUsername(), "Nadar", 1);
		graphInterests.addEdge("Guitarra", user1.getUsername(),1);
		graphInterests.addEdge("Guitarra", user2.getUsername(),1);
		graphInterests.addEdge("Guitarra", user3.getUsername(),1);
		graphInterests.addEdge("Nadar", user1.getUsername(), 1);
		graphInterests.addEdge("Nadar", user2.getUsername(), 1);
		graphInterests.addEdge("Nadar", user3.getUsername(), 1);
		graphInterests.addEdge("Dormir", user4.getUsername(), 1);
		graphInterests.addEdge("Dormir", user1.getUsername(), 1);
		graphInterests.addEdge("Guitarra", user3.getUsername(), 1);
		graphInterests.addEdge("Nadar", user5.getUsername(), 1);
		graphInterests.addEdge("Gimnasio", user6.getUsername(), 1);
		graphInterests.addEdge("Guitarra", user6.getUsername(), 1);
		graphInterests.addEdge("Cine", user7.getUsername(), 1);
		graphInterests.addEdge("Cine", user8.getUsername(), 1);
		graphInterests.addEdge("Cine", user9.getUsername(), 1);
		graphInterests.addEdge("Nadar", user7.getUsername(), 1);
		graphInterests.addEdge("Amigos", user7.getUsername(), 1);
		graphInterests.addEdge("Dormir", user8.getUsername(), 1);
		graphInterests.addEdge("Guitarra", user8.getUsername(), 1);
		graphInterests.addEdge("Dormir", user10.getUsername(), 1);
		graphInterests.addEdge("Bailar", user10.getUsername(), 1);
		graphInterests.addEdge("Bailar", user11.getUsername(), 1);
		graphInterests.addEdge("Gimnasio", user12.getUsername(), 1);
		graphInterests.addEdge("Nadar", user12.getUsername(), 1);

		//TIEMPO long initTime = System.nanoTime();
		long initTime = System.nanoTime();
		//-----------------------

		boolean loop = true;
		do {
			int posicionadorDeTemp = 0;
			int ans = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Be-my-Pal "
					+ "\nWhat do you want to do? \n1) Sign Up \n2) Sign In\n3) Exit: \nAnswer (1, 2, 3): ")) ;
			//------------------------------Registarse ------------------------------------------------------//
			if(ans == 1){ 
				boolean confirmUser = true;
				String user = ""; 
				do{
					user = JOptionPane.showInputDialog("Create Username: ");
					if(hash.search(user)){
						JOptionPane.showMessageDialog(null, "This username already exists! \n Try another one");
					} else {
						hash.insert(user);
						confirmUser = false;
					}
				} while(confirmUser);
				JPasswordField pf = new JPasswordField();
				int pass = JOptionPane.showConfirmDialog(null, pf, "Create Password: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				String password = "";
				if (pass == JOptionPane.OK_OPTION) {
					password = new String(pf.getPassword());
					System.err.println("You entered: " + password);
				}
				String name = JOptionPane.showInputDialog("First Name: ");
				String lastname = JOptionPane.showInputDialog("Last Name: ");
				String date = JOptionPane.showInputDialog("Birth Date: ");
				int interests = Integer.parseInt(JOptionPane.showInputDialog("How many interests or hobbies do you want to have \nin comun "
						+ "with your friends? (1,2, ... n) "));
				User newUser = new User(user, password, name, lastname, date, interests);
				graphInterests.addVertex(user);
				String myInterest = JOptionPane.showInputDialog("Write an interest or hobby");
				int gradeInterest = 0;
				System.out.println( "Existe el vertice? " + hashIntersts.search(myInterest));
				if(!hashIntersts.search(myInterest)){
					graphInterests.addVertex(myInterest);
					gradeInterest = Integer.parseInt(JOptionPane.showInputDialog("Do you \n1- Love it\n2- Enjoy it\n3- Practice it?"));
					graphInterests.addEdge(myInterest, newUser.getUsername(), gradeInterest);
					graphInterests.addEdge(newUser.getUsername(), myInterest, 1);
				} else {
					gradeInterest = Integer.parseInt(JOptionPane.showInputDialog("Do you \n1- Love it\n2- Enjoy it\n3- Practice it?"));
					graphInterests.addEdge(myInterest, user, gradeInterest);
					graphInterests.addEdge(user, myInterest, gradeInterest);
					
				}
				
				int confirm = JOptionPane.showConfirmDialog(null, "Do you want to add another interest or hobby?", null, JOptionPane.YES_NO_OPTION);
				while(confirm == JOptionPane.YES_NO_OPTION) {
					myInterest = JOptionPane.showInputDialog("Write an interest or hobby");
					if(!hashIntersts.search(myInterest)){
						graphInterests.addVertex(myInterest);
					} else {
						gradeInterest = Integer.parseInt(JOptionPane.showInputDialog("Do you \n1- Love it\n2- Enjoy it\n3- Practice it?"));
						System.out.println(" " + gradeInterest);
						graphInterests.addEdge(user, myInterest, gradeInterest);
						graphInterests.addEdge(myInterest, user, gradeInterest);
					}
					
					confirm = JOptionPane.showConfirmDialog(null, "Do you want to add another interest or hobby?", null, JOptionPane.YES_NO_OPTION);
				}
				System.out.println(password);
				
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
								int option = Integer.parseInt(JOptionPane.showInputDialog("WELCOME " + temp.getFullName() + "\nYou are logged in \n "
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
												+ "\n1) First Name \n2) Last Name \n3) Date Birth \n4) Password \n5) Add new interest or hobby\n6) Delete account\n7) Go back"));
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
											String date = JOptionPane.showInputDialog("Date Birth: ");
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
											String interest = JOptionPane.showInputDialog("Write an interest or hobby");
											int gradeInterest = Integer.parseInt(JOptionPane.showInputDialog("Do you \n1- Love it\n2- Enjoy it\n3- Practice it?"));
											if(!hashIntersts.search(interest)){
												graphInterests.addVertex(interest);
												graphInterests.addEdge(temp.getUsername(), interest, gradeInterest);
												graphInterests.addEdge(interest, temp.getUsername(), gradeInterest);
												
											}
											int confirm = JOptionPane.showConfirmDialog(null, "Do you want to add another interest or hobby?", null, JOptionPane.YES_NO_OPTION);
											System.out.println("ANS another interests " + confirm);
											while(confirm == JOptionPane.YES_NO_OPTION) {
												interest = JOptionPane.showInputDialog("Write an interest or hobby");
												if(!hashIntersts.search(interest)){
													graphInterests.addVertex(interest);
													gradeInterest = Integer.parseInt(JOptionPane.showInputDialog("Do you \n1- Love it\n2- Enjoy it\n3- Practice it?"));
													graphInterests.addEdge(temp.getUsername(), interest, gradeInterest);
													graphInterests.addEdge(interest, temp.getUsername(), gradeInterest);
												} else {
													gradeInterest = Integer.parseInt(JOptionPane.showInputDialog("Do you \n1- Love it\n2- Enjoy it\n3- Practice it?"));
													System.out.println(" " + gradeInterest);
													graphInterests.addEdge(temp.getUsername(), interest, gradeInterest);
													graphInterests.addEdge(interest, temp.getUsername(), gradeInterest);
												}
												
												confirm = JOptionPane.showConfirmDialog(null, "Do you want to add another interest or hobby?", null, JOptionPane.YES_NO_OPTION);
												System.out.println("CONFIRM " + confirm);
											}
											
											break;

										case 6:
											int ansDelete = JOptionPane.showConfirmDialog(null, "Are you sure that you want to delete your account?",
													"Warning", JOptionPane.YES_NO_OPTION);
											if(ansDelete == 0) {
												for(int i = 0; i < userList.size(); i++) {
													graphUsers.removeEdge(temp, userList.get(i));
												}
												/*while(graphInterests.getToVertices(temp.getUsername()) != null)
													graphInterests.getToVertices(temp.getUsername()).dequeue();*/
												graphUsers.removeVertex(temp);
												graphInterests.removeVertex(temp.getUsername());
												userList.remove(temp);
											}
											temp = null;
											editProfile = false;
											break;
										default:
											int ans1 = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Warning", JOptionPane.YES_NO_OPTION);
											if(ans1 == 0 && graphUsers.hasVertex(temp)){
												//copiar cambios
												userList.add(posicionadorDeTemp, temp);
												graphUsers.addVertex(temp, graphUsers.indexIs(temp2));
												System.out.println("Copiando cambios");
											}
											else if(!graphUsers.hasVertex(temp)) {
												temp = null;
												System.out.println(graphInterests.breadthPath("marco", "hector"));
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
							while(cualquiera && temp != null);
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
				JOptionPane.showMessageDialog(null, "Be-My-Pal\nGoodbye");
				loop = false;
			}
		} while(loop);

		long estimateTime = (System.nanoTime() - initTime) / 1000000000 ;
		System.out.println(estimateTime + " sec");
	}
}
package fr.dawan.javaAppronfondissement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.dawan.dao.UtilisateurDao;
import fr.dawan.model.Utilisateur;
import fr.dawan.utils.ConnexionBDD;

import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenPrincipale extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenPrincipale frame = new FenPrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenPrincipale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 399, 288);
		contentPane.add(scrollPane);

		remplirTable();

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSupprimerClick();
			}
		});
		
		btnSupprimer.setBounds(419, 87, 89, 23);
		contentPane.add(btnSupprimer);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(419, 121, 89, 23);
		contentPane.add(btnAjouter);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(419, 155, 89, 23);
		contentPane.add(btnModifier);
	}

	protected void btnSupprimerClick() {
		int selected = table.getSelectedRow();
		
		if (selected == -1) {
			JOptionPane.showMessageDialog(this, "Vous devez selectionner une ligne");
		}
		else {
			int rep =JOptionPane.showConfirmDialog(this, "Êtes-vous sur?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if(rep == JOptionPane.YES_OPTION) {
				try {
					
					long id = (Long) table.getValueAt(selected, 0);
					Connection cnx = ConnexionBDD.getConnection();
					UtilisateurDao.supprimer(id, cnx, true);
					remplirTable();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage());
				}
			}
		}
	}

	private void remplirTable() {
		try {

			Object[] colonnes = { "id", "Nom", "Prenom" };
			Connection cnx = ConnexionBDD.getConnection();
			List<Utilisateur> lu = UtilisateurDao.lireToutTable(cnx, true);
			Object[][] donnees = new Object[lu.size()][3];
			
			int i = 0;
			for (Utilisateur u : lu) {
				System.out.println(u);
				donnees[i][0] = u.getIdentifiant();
				donnees[i][1] = u.getNom();
				donnees[i][2] = u.getPrenom();
				i++;
			}
			
			table = new JTable(donnees, colonnes);
			
			scrollPane.setViewportView(table);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage());
		}

	}
}

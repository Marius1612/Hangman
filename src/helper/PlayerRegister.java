package helper;

import constants.ApplicationConstants;
import model.Player;
import model.Players;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

import static sun.audio.AudioPlayer.player;

public class PlayerRegister {
    public void registerPlayer(Player player) {
        File playerFile = new File(ApplicationConstants.APP_FOLDER_DATA_PATH +
                ApplicationConstants.PATH_SEPARATOR +
                ApplicationConstants.PLAYERS_FOLDER_NAME +
                ApplicationConstants.PATH_SEPARATOR +
                player.getName());
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Player.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.marshal(player, playerFile);
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }

    public void registerPlayer(Players players) {
        File playersFile = new File(ApplicationConstants.APP_FOLDER_DATA_PATH +
                ApplicationConstants.PATH_SEPARATOR +
                ApplicationConstants.PLAYERS_FOLDER_NAME +
                ApplicationConstants.PATH_SEPARATOR +
              ApplicationConstants.PLAYER_LIST);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Player.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.marshal(players, playersFile);
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }

    public Players readPlayerList() {
       Players players = null;
        File playerFile = new File(ApplicationConstants.APP_FOLDER_DATA_PATH +
                ApplicationConstants.PATH_SEPARATOR +
                ApplicationConstants.PLAYERS_FOLDER_NAME +
                ApplicationConstants.PATH_SEPARATOR +
                ApplicationConstants.PLAYER_LIST);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Player.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            players=(Players)jaxbUnmarshaller.unmarshal(playerFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return players;
    }
}
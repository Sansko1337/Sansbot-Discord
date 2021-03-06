package nl.imine.discord.command;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import nl.imine.discord.logic.Member;
import nl.imine.discord.model.Message;
import nl.imine.discord.service.ChannelService;
import nl.imine.vaccine.annotation.Component;

@Component
public class PatatCommand implements Command {

	private final CommandHandler commandHandler;
	private final ChannelService channelService;
	private final List<String> triggers;

	public PatatCommand(CommandHandler commandHandler, ChannelService channelService) {
		this.commandHandler = commandHandler;
		this.channelService = channelService;
		this.triggers = new ArrayList<>();
		this.triggers.add("WeVliegenErIn");
	}

	@PostConstruct
	public void postConstruct() {
		commandHandler.registerCommand(this);
	}

	@Override
	public List<String> getTriggers() {
		return triggers;
	}

	@Override
	public void handle(Member member, Message message) {
		Message reply = new Message();
//		Path imagePath = Paths.get("WeVliegenErIn.jpg");
		reply.setContent("PATAT!");
//		try {
//			reply.setFile(Files.readAllBytes(imagePath));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		channelService.createMessage(message.getChannelId(), reply);
	}
}

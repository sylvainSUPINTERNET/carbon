package com.carbon.apicarbon;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.carbon.apicarbon.models.Effect;
import com.carbon.apicarbon.models.Inventory;
import com.carbon.apicarbon.models.Item;
import com.carbon.apicarbon.models.ItemType;
import com.carbon.apicarbon.models.Profile;
import com.carbon.apicarbon.models.Users;
import com.carbon.apicarbon.repositories.EffectRepository;
import com.carbon.apicarbon.repositories.InventoryRepository;
import com.carbon.apicarbon.repositories.ItemRepository;
import com.carbon.apicarbon.repositories.ItemTypeRepository;
import com.carbon.apicarbon.repositories.ProfileRepository;
import com.carbon.apicarbon.repositories.UserRepository;
import com.carbon.apicarbon.staticEnum.ClassEnum;
import com.carbon.apicarbon.staticEnum.ItemEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ApiCarbonApplication implements CommandLineRunner {

	@Autowired
	EffectRepository effectRepository;
	@Autowired
	ItemTypeRepository itemTypeRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	ProfileRepository profileRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiCarbonApplication.class, args);
	}

	
	/**
	 * client call localhost:9999
	 * If not authenticated, ask for authorization (OAuth2)
	 * If success, send user back to the client (JSESSIONID is set for proof)
	 * @param httpServletResponse
	 */
	@GetMapping("/")
	public void method(HttpServletResponse httpServletResponse, @AuthenticationPrincipal OAuth2User principal) {

		if ( principal != null ) {
			System.out.println(principal.getName());
			System.out.println(principal.getAttributes());
	
			principal.getAttributes().entrySet().stream().forEach(attribute -> System.out.println(attribute.getKey() + " : " + attribute.getValue() ));
		} else {
			System.out.println("NO OAUTH2 USER AUTHENTICATED");
		}

		httpServletResponse.setHeader("Location", "http://localhost:3000");
		httpServletResponse.setStatus(302);
	}

	@GetMapping("/test")
	public ResponseEntity<?> methodTest(@AuthenticationPrincipal OAuth2User principal) {

		System.out.println(principal.getName());
		System.out.println(principal.getAttributes());

		principal.getAttributes().entrySet().stream().forEach(attribute -> System.out.println(attribute.getKey() + " : " + attribute.getValue() ));
		return ResponseEntity.ok().body("salut");
	}


	@Override
	public void run(String... args) throws Exception {

		Effect effectHearthstone = new Effect("Pierre de foyer", "Réinitialise le nombre de swipe à 60.");
		Set<Effect> effectsListMiscHearthstone = new HashSet<Effect>();
		effectsListMiscHearthstone.add(effectHearthstone);
		this.effectRepository.save(effectHearthstone);

		ItemType miscType = new ItemType("Divers");
		Set<ItemType> itemsMiscType = new HashSet<ItemType>();
		itemsMiscType.add(miscType);
		this.itemTypeRepository.save(miscType);
		
		if ( this.itemRepository.findByName("Pierre de foyer").isEmpty() ) {
			Item itemHearthStone = new Item("Pierre de foyer", UUID.randomUUID().toString(), (long) 1, (long) 1, "https://wow.zamimg.com/images/wow/icons/large/inv_misc_rune_01.jpg", 2 , "Réinitialiser votre nombre de swipe pour la journée !", true, effectsListMiscHearthstone, itemsMiscType, ItemEnum.commun.name());
			this.itemRepository.save(itemHearthStone);
		}

		List<Item> i = this.itemRepository.findByName("Pierre de foyer");
		List<Item> items = new ArrayList<Item>();
		items.add(i.get(0));
		Inventory inventory = new Inventory(16, items);
		this.inventoryRepository.save(inventory);

		Users user1;
		Optional<Users> u = this.userRepository.findByEmail("test@test.com");
		if ( !u.isPresent() ) {
			user1 = new Users("test@test.com", "testeur", "testName", "testProvider");
		} else {
			user1 = u.get();
		}


		// Profile profile = new Profile(0L, 1L, inventory, 70L, 0L, null);
		// user1.setProfile(profile);
		// this.profileRepository.save(profile);
		// this.userRepository.save(user1);


		List<Item> itemBaseClasseWar = this.itemRepository.findByName("Lames de forceur");
		List<Item> itemBaseMage = this.itemRepository.findByName("Le bob gucci");
		List<Item> itemBaseMonk = this.itemRepository.findByName("Le calepin");

		if ( itemBaseClasseWar.isEmpty()) {
			Effect effectWarClasseBasicItem = new Effect("La voie du Guerrier", "increase_profil_display_priority");
			Set<Effect> effectsListMiscBasicWarClasse = new HashSet<Effect>();
			effectsListMiscBasicWarClasse.add(effectWarClasseBasicItem);
			this.effectRepository.save(effectWarClasseBasicItem);	
			ItemType classeTypeWar = new ItemType("Classe Guerrier");
			Set<ItemType> classesTypeWarrior = new HashSet<ItemType>();
			classesTypeWarrior.add(classeTypeWar);
			this.itemTypeRepository.save(classeTypeWar);
			Item nWarBaseClasse = new Item("Lames de forceur", UUID.randomUUID().toString(), (long) 1, (long) 1, "https://wow.zamimg.com/images/wow/icons/large/spell_holy_blessingofstrength.jpg", 2 , "Augmente légèrement vos chances d'avoir votre profil mise en avant", true, effectsListMiscBasicWarClasse, classesTypeWarrior, ItemEnum.epique.name());
			this.itemRepository.save(nWarBaseClasse);
		}

		if ( itemBaseMage.isEmpty()) {
			Effect effectWarClasseBasicItem = new Effect("La voie du Mage", "increase_profil_picture_limit");
			Set<Effect> effectsListMiscBasicWarClasse = new HashSet<Effect>();
			effectsListMiscBasicWarClasse.add(effectWarClasseBasicItem);
			this.effectRepository.save(effectWarClasseBasicItem);	
			ItemType classeTypeWar = new ItemType("Classe Mage");
			Set<ItemType> classesTypeWarrior = new HashSet<ItemType>();
			classesTypeWarrior.add(classeTypeWar);
			this.itemTypeRepository.save(classeTypeWar);
			Item nWarBaseClasse = new Item("Le bob gucci", UUID.randomUUID().toString(), (long) 1, (long) 1, "https://wow.zamimg.com/images/wow/icons/large/inv_helm_cloth_witchhat_b_01.jpg", 2 , "Augmente de 1 la limite du nombre de photo de profil", true, effectsListMiscBasicWarClasse, classesTypeWarrior,ItemEnum.epique.name());
			this.itemRepository.save(nWarBaseClasse);
		}

		if ( itemBaseMonk.isEmpty()) {
			Effect effectWarClasseBasicItem = new Effect("La voie du Moine", "increase_profil_hobbies_limit");
			Set<Effect> effectsListMiscBasicWarClasse = new HashSet<Effect>();
			effectsListMiscBasicWarClasse.add(effectWarClasseBasicItem);
			this.effectRepository.save(effectWarClasseBasicItem);	
			ItemType classeTypeWar = new ItemType("Classe Moine");
			Set<ItemType> classesTypeWarrior = new HashSet<ItemType>();
			classesTypeWarrior.add(classeTypeWar);
			this.itemTypeRepository.save(classeTypeWar);
			Item nWarBaseClasse = new Item("Le calepin", UUID.randomUUID().toString(), (long) 1, (long) 1, "https://wow.zamimg.com/images/wow/icons/large/inv_misc_note_04.jpg", 2 , "Augmente la limite d'affichage pour vos hobbies", true, effectsListMiscBasicWarClasse, classesTypeWarrior, ItemEnum.epique.name());
			this.itemRepository.save(nWarBaseClasse);
		}


		// Add items for class Mage / War / Monk
		// hat mage : https://wow.zamimg.com/images/wow/icons/large/inv_helm_cloth_witchhat_b_01.jpg"
		// effect : https://wow.zamimg.com/images/wow/icons/large/spell_arcane_focusedpower.jpg

		// War : https://wow.zamimg.com/images/wow/icons/large/spell_holy_blessingofstrength.jpg
		// effect : 

		// Monk : https://wow.zamimg.com/images/wow/icons/large/spell_holy_prayerofmendingtga.jpg
		//https://wow.zamimg.com/images/wow/icons/medium/achievement_legionpvp2tier4.jpg



		// /**
		//  * Generate MOCK
		//  */


		// ItemType itemType = new ItemType("Epée 2M");
		// this.itemTypeRepository.save(itemType);
		// ArrayList<ItemType> itemsType = new ArrayList<ItemType>();
		// itemsType.add(itemType);

		// Effect effect = new Effect("Tranquility", "Give you tranquility !");
		// ArrayList<Effect> effectsList = new ArrayList<Effect>();
		// effectsList.add(effect);
		// this.effectRepository.save(effect);

		// Item item = new Item("Epee de tranquilité", UUID.randomUUID().toString(), (long) 10, (long) 70, "http://osef.com", 2 , "Une épée pour être tranquille", false, effectsList, itemsType);
		// Item item2 = new Item("Epee de tranquilité Boosted", UUID.randomUUID().toString(), (long) 10, (long) 70, "http://osef.com", 2 , "Une épée pour être tranquille", false, effectsList, itemsType);

		// this.itemRepository.save(item);
		// this.itemRepository.save(item2);

		
		// Users user1 = new Users("test@test.com", "testeur", "testName", "testProvider");
		// this.userRepository.save(user1);


		// List<Item> itemObjectNotTransiant = this.itemRepository.findAll();
		// List<Item> items = new ArrayList<Item>();
		// items.add(itemObjectNotTransiant.get(0));
		// items.add(itemObjectNotTransiant.get(1));

		// Inventory inventory = new Inventory(3, items);
		// this.inventoryRepository.save(inventory);
		
		// Profile profile = new Profile((long)0, (long)70, inventory);
		// user1.setProfile(profile);

		// this.profileRepository.save(profile);
		// this.userRepository.save(user1);



	}

}

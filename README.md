![Generic badge](https://img.shields.io/badge/api_version-1.0.2-green.svg)
# TownyCore
- Towny 시스템의 전체적인 관리를 하는 플러그인입니다.

---

## Getting API

```dockerfile
TownyCore$getApi: Get TownyApi
```

## Usage API
### - Gradle
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.hodongwook:TownyCore-api:1.0.2'
}
```
### - Adapter
[테스트 코드](https://github.com/StarlyTowny/ST-TownyCore/blob/main/ST-TownyCore-api/src/test/java/kr/jb/test/AdapterTest.java)
 1. Create Custom Adapter Class
```java
public final class RegionLevelAdapter extends RegionAdapter implements Savable, CommandExecutable {
    
    private int level;
    private long exp;
    
    public int getLevel() { return level; }
    public long getExp() { return exp; }
    
    /*...other settings...*/
    
    @Override
    public String getCommand() {
        return "레벨";
    }
    
    @Override
    public void execute(CommandSender sender, Region region, String label, String[] args) {
        sender.sendMessage("마을 레벨 : " + level);
    }
    
}
```
 2. Register Custom Adapter
```java
public class TestPlugin extends JavaPlugin {
    
    @Override 
    public void onEnable() {
        RegionAdapterRegistry registry = TownyCore.getApi().getRegionAdapterRegistry();
        registry.register(RegionLevelAdapter.class, new RegionLevelAdapter());
    }
}
```
 3. Getting Custom Adapter
 ```java
 public class TestClass {

    private final TownyApi api = TownyCore.getApi();
    public void usageAdapter(Player player) {
        RegionManager regionManager = api.getRegionManager();
        Region region = regionManager.getRegion(regionId);
        
        RegionLevelAdapter levelData = region.getData(RegionLevelAdapter.class);
        levelData.getLevel();
        levelData.getExp();
    }

}
 ```
### - RegionManager & Region Example
[테스트 코드](https://github.com/StarlyTowny/ST-TownyCore/blob/main/ST-TownyCore-api/src/test/java/kr/jb/test/RegionTest.java)
```java
public class TestClass {

    private final TownyApi api = TownyCore.getApi();
    
    public void usageApi(int regionId, Player player, String regionName) {
        // example region manager methods
        RegionManager regionManager = api.getRegionManager();
        
        // get region
        regionManager.getRegion(regionId);      // Get Region From RegionId     (int)
        regionManager.getRegion(player);        // Get Region From Player       (Player)
        regionManager.getRegion(RegionName);    // Get Region From RegionName   (String)
        
        // example region methods
        Region region = regionManager.getRegion(regionId);
        
        // check region instance
        Region region = regionManager.getRegion(regionId);
        if(region instanceof PlayerRegion) {
            PlayerRegion playerRegion = (PlayerRegion) region;
            playerRegion.sendMessage("hello my region members!");
            
            // try to add member
            switch (playerRegion.addMember(Bukkit.getPlayer("test"))) {
                case SUCCESS:
                    // success: add member
                    break;
                case IS_MEMBER:
                    // fail: already region member
                    break;
                case MAX_PLAYER:
                    // fail: maximum player size
                    break;
            }
        } else if(region instanceof ServerRegion)
            // send message for player in region's range
            region.getPlayers().forEach(innerPlayer -> innerPlayer.sendMessage("hello my region visitors!"));
    }

}
```
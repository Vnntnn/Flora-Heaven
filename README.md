One of greatest projects in OOP class.

```mermaid
classDiagram
direction BT
class ArcanashopController {
  + ArcanashopController(Player) 
  - Player player
  + mouseMoved(MouseEvent) void
  - startTimer() void
  + mouseEntered(MouseEvent) void
  + mouseReleased(MouseEvent) void
  + updatetreeMap() void
  + mouseClicked(MouseEvent) void
  + mouseExited(MouseEvent) void
  + actionPerformed(ActionEvent) void
  + mousePressed(MouseEvent) void
  + mouseDragged(MouseEvent) void
   Player player
}
class ArcanashopWindow {
  + ArcanashopWindow(ArcanashopController) 
  - JButton combine
  - JLabel timeLabel
  - Player player
  - JButton book
  - JButton shop
  - JPanel drop2
  - JPanel drop1
  + loadAllTreeHolders() void
  + getsuSubQuestTextPanel1() SubQuestTextPanel
  + getsuSubQuestTextPanel2() SubQuestTextPanel
  + getsuSubQuestTextPanel3() SubQuestTextPanel
   JPanel drop1
   JLabel timeLabel
   JPanel[] panel
   JLayeredPane JLayeredPane
   Player player
   JButton mainQuest
   JPanel drop2
   JButton[] subQuest
   JButton book
   JButton shop
   JButton combine
}
class ArrowsPanel {
  + ArrowsPanel() 
}
class AssetsLoaderArcanashop {
  - AssetsLoaderArcanashop() 
  - AssetsLoaderArcanashop instance
  + main(String[]) void
   AssetsLoaderArcanashop instance
}
class AssetsLoaderBook {
  - AssetsLoaderBook() 
  - AssetsLoaderBook instance
   AssetsLoaderBook instance
}
class AssetsLoaderLobby {
  - AssetsLoaderLobby() 
  - AssetsLoaderLobby instance
   AssetsLoaderLobby instance
}
class AssetsLoaderMainQuests {
  - AssetsLoaderMainQuests() 
  - AssetsLoaderMainQuests instance
   AssetsLoaderMainQuests instance
}
class AssetsLoaderTreeShop {
  - AssetsLoaderTreeShop() 
  - AssetsLoaderTreeShop instance
   AssetsLoaderTreeShop instance
}
class AssetsLoaderTrees {
  - AssetsLoaderTrees() 
}
class AssetsLoaderTreesCombine {
  - AssetsLoaderTreesCombine() 
}
class AurelianWhisper {
  + AurelianWhisper() 
}
class AurelianWhisperPanel {
  + AurelianWhisperPanel() 
  # paintComponent(Graphics) void
}
class BackgroundPanel {
  + BackgroundPanel(String) 
  - loadImage() void
  # paintComponent(Graphics) void
}
class BackgroundPanel {
  + BackgroundPanel(String) 
  # paintComponent(Graphics) void
  - loadImage() void
}
class BaseCollectionTrees {
  + BaseCollectionTrees() 
  - List~Tree~ baseTrees
   List~Tree~ baseTrees
}
class BasicCombineTree {
  + BasicCombineTree() 
  - addCombination(String, String, Tree) void
  + canCombine(Tree, Tree) boolean
  + combine(Tree, Tree) Tree
}
class Bloodvalor_blossomPanel {
  + Bloodvalor_blossomPanel() 
  # paintComponent(Graphics) void
}
class BookController {
  + BookController(Player) 
  - int currentCombineIndex
  - boolean showingTrees
  - int currentTreeIndex
  - startAnimation() void
  + windowGainedFocus(WindowEvent) void
  - changeToNextPage() void
  + windowLostFocus(WindowEvent) void
  - changeToPrevPage() void
  - updateView() void
  + nextPage() void
  + prevPage() void
   int currentTreeIndex
   int currentCombineIndex
   boolean showingTrees
}
class BookWindow {
  + BookWindow(BookController) 
  + showSwappingAnimation(boolean) void
}
class BookbackgroundPanel {
  + BookbackgroundPanel() 
  # paintComponent(Graphics) void
}
class BuybuttonPanel {
  + BuybuttonPanel() 
  + updateButtonState(int, boolean) void
  # paintComponent(Graphics) void
}
class Chandra {
  + Chandra() 
}
class ChandraPanel {
  + ChandraPanel() 
  # paintComponent(Graphics) void
}
class ClockGIFPanel {
  + ClockGIFPanel() 
}
class Collection {
  + Collection() 
  # Collection(List~Tree~, int) 
  - List~Tree~ baseTrees
  - initializeBaseTrees() void
   List~Tree~ baseTrees
}
class Combinable {
<<Interface>>
  + combine(Tree, Tree) Tree
  + canCombine(Tree, Tree) boolean
}
class CounterPanel {
  + CounterPanel() 
  # paintComponent(Graphics) void
}
class CreditController {
  + CreditController(LobbyController) 
  - loadBackgroundImage(String) Image
  - loadFont(String) Font
  + show() void
  - handleResourceError(Exception) void
   List~String~ creditNames
}
class CreditView {
  + CreditView(Font, LobbyController) 
  - Image backgroundImage
  - List~String~ names
  - boolean isVisible
  - checkButtonClick(int, int) void
  - initializeUI() void
  + toFront() void
  + close() void
  + show() void
   Image backgroundImage
   boolean isVisible
   List~String~ names
}
class CrimsonWard {
  + CrimsonWard() 
}
class CrimsonWardPanel {
  + CrimsonWardPanel() 
  # paintComponent(Graphics) void
}
class Cryptara {
  + Cryptara() 
}
class CryptaraPanel {
  + CryptaraPanel() 
  # paintComponent(Graphics) void
}
class Day_Ending {
  + Day_Ending(String, Player) 
  - initialize() void
}
class DaypapercardholderPanel {
  + DaypapercardholderPanel() 
  # paintComponent(Graphics) void
}
class DaysPanel {
  + DaysPanel(Player) 
  # paintComponent(Graphics) void
}
class DeskBackgroundPanel {
  + DeskBackgroundPanel() 
  # paintComponent(Graphics) void
}
class Eclipsara {
  + Eclipsara() 
}
class EclipsaraPanel {
  + EclipsaraPanel() 
  # paintComponent(Graphics) void
}
class Emberveil {
  + Emberveil() 
}
class EmberveilPanel {
  + EmberveilPanel() 
  # paintComponent(Graphics) void
}
class EndingController {
  + EndingController() 
  - loadFont(String) Font
  - initialize() void
  - loadBackgroundImage(String) Image
  - setupEventListeners() void
  - handleResourceError(Exception) void
  - createLabelInfos() Map~String, StoryLabelInfo~
  - loadResources() void
  + dispose() void
}
class EndingDay {
  + EndingDay(Player) 
  + dayEnd() void
}
class EndingView {
  + EndingView(Font, Image, Map~String, StoryLabelInfo~) 
  - JButton nextButton
  - initializeUI(Image, Map~String, StoryLabelInfo~) void
  + close() void
  + show() void
   JButton nextButton
}
class Everguard {
  + Everguard() 
}
class EverguardPanel {
  + EverguardPanel() 
  # paintComponent(Graphics) void
}
class FailController {
  + FailController(Player) 
  - loadFont(String) Font
  + dispose() void
  - loadBackgroundImage(String) Image
  - handleResourceError(Exception) void
  - loadResources() void
  - initialize() void
  - setupEventListeners() void
  - createLabelInfos() Map~String, StoryLabelInfo~
}
class FailView {
  + FailView(Font, Image, Map~String, StoryLabelInfo~) 
  - JFrame frame
  - JButton nextButton
  + show() void
  + close() void
  - initializeUI(Font, Image, Map~String, StoryLabelInfo~) void
   JButton nextButton
   JFrame frame
}
class Firefly {
  + Firefly(int, int, int, int) 
  # adjustGlow() void
  + draw(Graphics2D) void
  + move() void
}
class FireflyGlowing {
  + FireflyGlowing(int, int, int, int) 
  + draw(Graphics2D) void
  # adjustGlow() void
}
class FireflysPanel {
  + FireflysPanel(LobbyController) 
  # paintComponent(Graphics) void
}
class FloraHeaven {
  + FloraHeaven() 
  + main(String[]) void
}
class FlowersPanel {
  + FlowersPanel() 
  # paintComponent(Graphics) void
}
class FortunaeVine {
  + FortunaeVine() 
}
class FortunaeVinePanel {
  + FortunaeVinePanel() 
  # paintComponent(Graphics) void
}
class GameboardPanel {
  + GameboardPanel() 
  # paintComponent(Graphics) void
}
class GifPanel {
  + GifPanel() 
}
class Harmonspire {
  + Harmonspire() 
}
class HarmonspirePanel {
  + HarmonspirePanel() 
  # paintComponent(Graphics) void
}
class HeartEclipse {
  + HeartEclipse() 
}
class HeartEclipsePanel {
  + HeartEclipsePanel() 
  # paintComponent(Graphics) void
}
class Heartroot {
  + Heartroot() 
}
class HeartrootPanel {
  + HeartrootPanel() 
  # paintComponent(Graphics) void
}
class Huolu {
  + Huolu() 
}
class HuoluPanel {
  + HuoluPanel() 
  # paintComponent(Graphics) void
}
class IllumisSprout {
  + IllumisSprout() 
}
class Illumis_sproutPanel {
  + Illumis_sproutPanel() 
  + paintComponent(Graphics) void
}
class LabelInfo {
  + LabelInfo(String, float, int, int, int, int) 
}
class LeftarrowPanel {
  + LeftarrowPanel() 
}
class LobbyController {
  + LobbyController() 
  - LobbyWindow view
  - ArrayList~Firefly~ fireflies
  + main(String[]) void
  + updateFireflies(int, int) void
  - initFireflies() void
  - addEventListeners() void
   LobbyWindow view
   LobbyController controller
   ArrayList~Firefly~ fireflies
}
class LobbyWindow {
  + LobbyWindow(LobbyController) 
  + main(String[]) void
   JButton creditsButton
   JButton quitButton
   JButton startButton
}
class LobbybackgroundPanel {
  + LobbybackgroundPanel() 
  # paintComponent(Graphics) void
}
class Luckybloom {
  + Luckybloom() 
}
class LuckybloomPanel {
  + LuckybloomPanel() 
  # paintComponent(Graphics) void
}
class LuminousFinder {
  + LuminousFinder() 
}
class LuminousFinderPanel {
  + LuminousFinderPanel() 
  # paintComponent(Graphics) void
}
class Lunacrypta {
  + Lunacrypta() 
}
class LunacryptaPanel {
  + LunacryptaPanel() 
  # paintComponent(Graphics) void
}
class MagicTablePanel {
  + MagicTablePanel() 
  # paintComponent(Graphics) void
}
class MailboxPanel {
  + MailboxPanel() 
  # paintComponent(Graphics) void
}
class MainQuestGIF {
  + MainQuestGIF() 
}
class MainQuestPanel {
  + MainQuestPanel() 
  # paintComponent(Graphics) void
}
class MainQuestWindow {
  + MainQuestWindow(Player) 
}
class Mindspire {
  + Mindspire() 
}
class MindspirePanel {
  + MindspirePanel() 
  # paintComponent(Graphics) void
}
class MoonfortuneBloom {
  + MoonfortuneBloom() 
}
class MoonfortuneBloomPanel {
  + MoonfortuneBloomPanel() 
  # paintComponent(Graphics) void
}
class OpenStoryController {
  + OpenStoryController() 
  - loadResources() void
  - setupEventListeners() void
  - createLabelInfos() Map~String, StoryLabelInfo~
  - loadFont(String) Font
  - handleResourceError(Exception) void
  - loadBackgroundImage(String) Image
  - initialize() void
}
class OpenStoryPage {
  + OpenStoryPage(Font, Image, Map~String, StoryLabelInfo~) 
  - JButton nextButton
  + close() void
  - createStyledButton(String, int, int, int, int) JButton
  - initializeUI(Image, Map~String, StoryLabelInfo~) void
  + show() void
   JButton nextButton
}
class Opening_day {
  + Opening_day(String, Player) 
  - initialize() void
}
class Player {
  + Player() 
  + Player(int, int, TreeObtains) 
  - TreeObtains obtainTrees
  - int coins
  - int day
   int coins
   int day
   TreeObtains obtainTrees
}
class QuestDescriptionsPanel {
  + QuestDescriptionsPanel(Player) 
  # paintComponent(Graphics) void
}
class QuestNumberPanel {
  + QuestNumberPanel(Player) 
  # paintComponent(Graphics) void
}
class QuestbackgroundPanel {
  + QuestbackgroundPanel() 
  # paintComponent(Graphics) void
}
class QuestsBoardPanel {
  + QuestsBoardPanel(Player) 
  # paintComponent(Graphics) void
}
class QuitController {
  + QuitController(LobbyController) 
  - initialize() void
  - handleResourceError(Exception) void
  + show() void
  - loadBackgroundImage(String) Image
  - setupEventListeners() void
  - loadFont(String) Font
}
class QuitView {
  + QuitView(Font, Image) 
  - JButton noButton
  - JButton yesButton
  + close() void
  + toFront() void
  - toBufferedImage(Image) BufferedImage
  - createRoundButton(String, Color, Font) JButton
  + show() void
  - initializeUI(Font) void
   JButton noButton
   boolean visible
   JButton yesButton
}
class RestartController {
  + RestartController(Player) 
  - loadBackgroundImage(String) Image
  - loadResources() void
  - setupEventListeners() void
  - initialize() void
  - createLabelInfos() Map~String, LabelInfo~
  - handleResourceError(Exception) void
  + dispose() void
  - loadFont(String) Font
  - loadImage(String, int, int) Image
}
class RestartView {
  + RestartView(Font, Image, Image, Image, Map~String, LabelInfo~) 
  - JFrame frame
  + close() void
  + show() void
  - initializeUI(Font, Image, Image, Image, Map~String, LabelInfo~) void
   JLabel yesButton
   JFrame frame
   JLabel noButton
}
class RightarrowPanel {
  + RightarrowPanel() 
}
class RoleController {
  + RoleController() 
  - RoleView view
  - loadResources() void
  - loadBackgroundImage(String) Image
  - setupEventListeners() void
  - loadFont(String) Font
  - handleResourceError(Exception) void
  - initialize() void
   RoleView view
}
class RoleView {
  + RoleView(Font, Image) 
  - JButton nextButton
  + show() void
  - initializeUI(Font, Image) void
  - createStyledButton(String, int, int, int, int, Font) JButton
  + close() void
   float opacity
   boolean undecorated
   JButton nextButton
   boolean visible
}
class Rootten {
  + Rootten() 
}
class RoottenPanel {
  + RoottenPanel() 
  # paintComponent(Graphics) void
}
class SecretController {
  + SecretController(Player) 
  - setupEventListeners() void
  - createLabelInfos() Map~String, StoryLabelInfo~
  - loadFont(String) Font
  - loadBackgroundImage(String) Image
  - loadResources() void
  - handleResourceError(Exception) void
  - initialize() void
  + dispose() void
}
class SecretView {
  + SecretView(Font, Image, Map~String, StoryLabelInfo~) 
  - JButton nextButton
  - JFrame frame
  + show() void
  + close() void
  - initializeUI(Font, Image, Map~String, StoryLabelInfo~) void
   JButton nextButton
   JFrame frame
}
class ShelfBackgroundPanel {
  + ShelfBackgroundPanel() 
  # paintComponent(Graphics) void
}
class ShopController {
  + ShopController(Player, ArcanashopWindow) 
  - Player player
  - BuybuttonPanel buybuttonPanel
  - List~Tree~ treeList
  + windowLostFocus(WindowEvent) void
  + canBuy(int) boolean
  + setupBuyButton(JButton, int) void
  - unlockTreeNextDay(int) void
  + updateButtonState(JButton, int) void
  + windowGainedFocus(WindowEvent) void
   Player player
   List~Tree~ treeList
   BuybuttonPanel buybuttonPanel
}
class ShopGIFPanel {
  + ShopGIFPanel() 
}
class ShopPanel {
  + ShopPanel() 
  # paintComponent(Graphics) void
}
class Shopbackground {
  + Shopbackground() 
  # paintComponent(Graphics) void
}
class Shoplogo {
  + Shoplogo() 
  # paintComponent(Graphics) void
}
class Shopwindow {
  + Shopwindow(ShopController) 
  + updateBuyButtonImage(int, boolean) void
}
class ShowDayEnding {
  + ShowDayEnding(int, Player) 
}
class ShowDayOpen {
  + ShowDayOpen(int, Player) 
}
class SilentGuardian {
  + SilentGuardian() 
}
class SilentGuardianPanel {
  + SilentGuardianPanel() 
  # paintComponent(Graphics) void
}
class SilentisShade {
  + SilentisShade() 
}
class SilenttisshadePanel {
  + SilenttisshadePanel() 
  + paintComponent(Graphics) void
}
class Soundmanager {
<<Interface>>
  + play() void
  + restart() void
  + pause() void
  + resume() void
  + stop() void
}
class StoryLabelInfo {
  + StoryLabelInfo(String, float, int, int, int, int) 
}
class StoryLabelInfo {
  + StoryLabelInfo(String, float, int, int, int, int) 
}
class StoryLabelInfo {
  + StoryLabelInfo(String, float, int, int, int, int, Color) 
  + StoryLabelInfo(String, float, int, int, int, int) 
}
class StoryLabelInfo {
  + StoryLabelInfo(String, float, int, int, int, int) 
}
class SubQuest1GIFPanel {
  + SubQuest1GIFPanel() 
}
class SubQuest2GIFPanel {
  + SubQuest2GIFPanel() 
}
class SubQuest3GIFPanel {
  + SubQuest3GIFPanel() 
}
class SubQuestGenerator {
  + SubQuestGenerator() 
  + generatorSubQuestTree(int) Tree
  + gethintString2() String
  + gethintString1() String
  + main(String[]) void
}
class SubQuestPanel {
  + SubQuestPanel() 
  # paintComponent(Graphics) void
}
class SubQuestTextPanel {
  + SubQuestTextPanel() 
  - JLabel hintJLabel1
  - JLabel hintJLabel2
  - JLabel hintJLabel3
   JLabel hintJLabel1
   JLabel hintJLabel2
   JLabel hintJLabel3
}
class SwapingPagePanel {
  + SwapingPagePanel() 
  # paintComponent(Graphics) void
   int activeAnimation
}
class Timer {
  + Timer(int) 
  - int sec
  + stopTimer() void
  + run() void
   int sec
   boolean timeUp
}
class Tree {
  + Tree() 
  + Tree(String, double, int, Component) 
  - String name
  - int star
  - double price
  - ArrayList~String~ hintList
  - Component image
  + addHintList(String) void
   String name
   Component image
   ArrayList~String~ hintList
   int star
   double price
}
class TreeBookGIFPanel {
  + TreeBookGIFPanel() 
}
class TreeHolderShelfPanel {
  + TreeHolderShelfPanel() 
  # paintComponent(Graphics) void
}
class TreeObtains {
  + TreeObtains() 
  + TreeObtains(List~Tree~) 
  - List~Tree~ obtainedTree
  + addTree(Tree) void
  + hasTree(Tree) boolean
   List~Tree~ obtainedTree
}
class TreesBookPanel {
  + TreesBookPanel() 
  # paintComponent(Graphics) void
}
class TreesDescriptionsPanel {
  + TreesDescriptionsPanel(BookController) 
  # paintComponent(Graphics) void
}
class UnavailableTrees {
  + UnavailableTrees() 
  # paintComponent(Graphics) void
}
class Valorvine {
  + Valorvine() 
}
class ValorvinePanel {
  + ValorvinePanel() 
  # paintComponent(Graphics) void
}
class Voxspire {
  + Voxspire() 
}
class VoxspirePanel {
  + VoxspirePanel() 
  # paintComponent(Graphics) void
}
class bgSound {
  + bgSound() 
  + stop() void
  - initSound() void
  + decreaseVolume(float) void
  + resume() void
  + restart() void
  + play() void
  + pause() void
   float volume
}
class bloodvalorTree {
  + bloodvalorTree() 
}
class candlePanel {
  + candlePanel() 
}
class combinePanel {
  + combinePanel(BookController) 
  # paintComponent(Graphics) void
}
class createButton {
  + createButton(String, int, int) 
}
class creditPage {
  + creditPage(LobbyController) 
}
class creditsBtnPanel {
  + creditsBtnPanel() 
  - createButton creditseButton
   JButton creditseButton
}
class fbookPanel {
  + fbookPanel() 
}
class quitBtnPanel {
  + quitBtnPanel() 
  - createButton quitBtn
   JButton quitBtn
}
class startBtnPanel {
  + startBtnPanel() 
  - createButton startBtn
   JButton startBtn
}

AurelianWhisper  -->  Tree 
Day_Ending  -->  BackgroundPanel 
Opening_day  -->  BackgroundPanel 
BaseCollectionTrees  -->  Collection 
BasicCombineTree  ..>  Combinable 
Chandra  -->  Tree 
CrimsonWard  -->  Tree 
Cryptara  -->  Tree 
Eclipsara  -->  Tree 
Emberveil  -->  Tree 
Everguard  -->  Tree 
FireflyGlowing  -->  Firefly 
FortunaeVine  -->  Tree 
Harmonspire  -->  Tree 
HeartEclipse  -->  Tree 
Heartroot  -->  Tree 
Huolu  -->  Tree 
IllumisSprout  -->  Tree 
RestartView  -->  LabelInfo 
Luckybloom  -->  Tree 
LuminousFinder  -->  Tree 
Lunacrypta  -->  Tree 
SubQuest3GIFPanel  -->  MainQuestGIF 
Mindspire  -->  Tree 
MoonfortuneBloom  -->  Tree 
Rootten  -->  Tree 
SilentGuardian  -->  Tree 
SilentisShade  -->  Tree 
EndingView  -->  StoryLabelInfo 
FailView  -->  StoryLabelInfo 
OpenStoryPage  -->  StoryLabelInfo 
SecretView  -->  StoryLabelInfo 
Valorvine  -->  Tree 
Voxspire  -->  Tree 
bgSound  ..>  Soundmanager 
bloodvalorTree  -->  Tree 
```

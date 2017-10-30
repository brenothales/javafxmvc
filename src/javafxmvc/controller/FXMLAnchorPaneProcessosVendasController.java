//    Tem que declarar dos tipo de lista venda
    @FXML
    private TableView<Venda> tableViewVendas;
//    Tem que declarar dos tipo de lista venda
    @FXML
    private TableColumn<Venda, Integer> tableColumnVendaCodigo;
//    Tem que declarar dos tipo de lista venda    
    @FXML
    private TableColumn<Venda, LocaleData> tableColumnVendaData;
//    Tem que declarar dos tipo de lista venda    
    @FXML
    private TableColumn<Venda, Venda> tableColumnVendaCliente;
    @FXML
    private Label labelVendaCodigo;
    @FXML
    private Label labelVendaData;
    @FXML
    private Label labelVendaValor;
    @FXML
    private Label labelVendaPago;
    @FXML
    private Label labelVendaCliente;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    
    
    private List<Venda> listVendas;
    private ObservableList<Venda> observableListVendas;
    
//    Atribuir para manipulação de banco de dados
    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private final VendaDAO vendaDAO = new VendaDAO();
    private final ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    


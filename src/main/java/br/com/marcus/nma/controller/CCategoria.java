package br.com.marcus.nma.controller;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import br.com.marcus.nma.dao.CategoriaDao;
import br.com.marcus.nma.domain.Categoria;

@SuppressWarnings("serial")
public class CCategoria extends SelectorComposer<Component> {

	// Declaração de Variáveis Wire
	@Wire
	private Listbox listCategoria;
	@Wire("#dlgCategoria #tbCategoria")
	private Textbox tbCategoria;
	@Wire("#dlgCategoria #tbDescricao")
	private Textbox tbDescricao;
	@Wire
	private Window dlgCategoria;

	// Declaração de Variáveis da clase.
	private Categoria categoria;
	private CategoriaDao categoriaDao;
	private ListModelList<Categoria> listModel;

	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		PreencherLista();
	}

	public void PreencherLista() {
		categoriaDao = new CategoriaDao();
		listModel = new ListModelList<Categoria>(categoriaDao.listar());
		this.listCategoria.setModel(listModel);
	}
	@Listen("onClick = #btnNovaCategoria")
	public void novo(){
		this.categoria = new Categoria();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Listen("onDeleteItem = #listCategoria")
	public void Deletar(Event event) {

		this.categoria = (Categoria) event.getData();
		Messagebox.show("Tem Certeza que deseja Excluir?", "Deseja Excluir?", Messagebox.YES | Messagebox.NO,
				Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event e) {
						if (Messagebox.ON_YES.equals(e.getName())) {
							categoriaDao.excluir(categoria);
							PreencherLista();
						}
					}
				});
	}

	@Listen("onClick = #btnSalvar")
	public void Salvar() {
		try {
			this.categoria.setCategoria(tbCategoria.getValue());
			this.categoria.setDescricao(tbDescricao.getValue());
			CategoriaDao categoriaDao = new CategoriaDao();
			categoriaDao.salvar(this.categoria);
			tbCategoria.setValue(null);
			tbDescricao.setValue(null);
			Messagebox.show("Categoria Salva");
			PreencherLista();
			dlgCategoria.setVisible(false);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messagebox.show("Erro ao Salvar Categoria");
		}
	}
	
	@Listen("onEditar = #listCategoria")
	public void Editar(Event event) {

		this.categoria = (Categoria) event.getData();
		tbCategoria.setValue(categoria.getCategoria());
		tbDescricao.setValue(categoria.getDescricao());
		
		
		
	}
}

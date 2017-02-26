package controllers;

import models.entity.*;

import play.data.*;
import play.db.jpa.*;
import play.mvc.*;

import javax.inject.Inject;

import java.util.*;
import java.util.Collections;
import java.util.stream.Collectors;


/**
 * NoteController
 */
public class NoteController extends Controller {

    private FormFactory formFactory;
    private JPAApi jpaApi;

    @Inject
    public NoteController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    /**
     * Opens a start page
     * @return start page
     */
    @Transactional
    public Result index() {

        List<Note> list = getNoteListFromDb();

        return ok(views.html.index.render(list));
    }

    /**
     * Get the list of the notes from data base
     * @return list
     */
    @Transactional
    private List<Note> getNoteListFromDb() {
        List<Note> list =
                (List<Note>) jpaApi.em().createQuery("select p from Note p").getResultList();
        Collections.sort(list);
        return list;
    }

    /**
     * Delete selected notes
     * @return result page
     */
    @Transactional
    public Result delete() {
        Map<String, String> form = Form.form().bindFromRequest().data();

        List list = form.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());

        if (!list.get(0).equals("")) {
            for (Object aList : list) {
                deleteNotedById(Integer.parseInt((String) aList));
            }
        }

        return redirect("/");
    }

    /**
     * Delete note by id
     * @param id of note
     * @return result
     */
    @Transactional
    private Result deleteNotedById(int id) {

        jpaApi.em().createQuery("DELETE FROM Note c WHERE c.id= :id")
                .setParameter("id", id)
                .executeUpdate();

        return ok("Field with id = " + id + " was deleted");
    }

    /**
     * Edit current note
     * @return result
     */
    @Transactional
    public Result edit() {

        Map<String, String> form = Form.form().bindFromRequest().data();

        String string = null;
        Note note = null;
        try {
            string = form.entrySet().stream().findFirst().get().getKey();
            note = jpaApi.em().find(Note.class, Integer.parseInt(string));
        } catch (NoSuchElementException ignored) {}

        return ok(views.html.edit.render(note));
    }

    /**
     * Add new note to data base
     * @return redirect on start page
     */
    @Transactional
    public Result add() {

        Note note = Form.form(Note.class).bindFromRequest().get();
        jpaApi.em().persist(note);

        return redirect("/");
    }

    /**
     * Save edited note to data base
     * @return redirect on start page
     */
    @Transactional
    public Result save() {

        Note note = Form.form(Note.class).bindFromRequest().get();
        jpaApi.em().merge(note);

        return redirect("/");
    }


}

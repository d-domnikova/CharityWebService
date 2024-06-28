package edu.domnikova.CharityWebService.project;

import edu.domnikova.CharityWebService.project.projectEntity.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model, @SortDefault.SortDefaults(@SortDefault("title")) Pageable pageable) {
        model.addAttribute("title", "Projects");
        model.addAttribute("projects", service.getProjects(pageable));
        return "project/projectList";
    }

    @GetMapping("/create")
    public String createProjectForm(Model model) {
        model.addAttribute("project", new CreateProjectFromData());
        modelAddEnumAttributes(model);
        return "project/projectForm";
    }

    @PostMapping("/create")
    public String createProject(@Validated(CreateProjectValidationGroupSequence.class)
                             @ModelAttribute("project") CreateProjectFromData formData,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            modelAddEnumAttributes(model);
            return "project/projectForm";
        }
        service.createProject(formData.projectParameters());
        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String editTeamMemberForm(@PathVariable("id") ProjectId projectId, Model model) {
        Project project = service
                .getProject(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        model.addAttribute("project", EditProjectFromData.editProjectFromData(project));
        modelAddEnumAttributes(model);
        model.addAttribute("editMode", EditMode.UPDATE);
        return "project/projectForm";
    }

    @PostMapping("/{id}/edit")
    public String editTeamMember(@PathVariable("id") ProjectId projectId,
                                 @Validated(EditProjectValidationGroupSequence.class)
                                 @ModelAttribute("project") EditProjectFromData formData,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            modelAddEnumAttributes(model);
            model.addAttribute("editMode", EditMode.UPDATE);
            return "project/projectForm";
        }
        service.editProject(projectId, formData.projectParameters());
        return "redirect:/projects";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") ProjectId projectId,
                             RedirectAttributes redirectAttributes) {
        Project project = service.getProject(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        service.deleteProject(projectId);
        redirectAttributes.addFlashAttribute("deletedProjectTitle",
                project.getTitle());
        return "redirect:/projects";
    }

    public void modelAddEnumAttributes(Model model) {
        model.addAttribute("categories", List.of(Category.ANIMAL_WELFARE, Category.EMERGENCY_AID,
                Category.HEALTHCARE, Category.NATURE_ENVIRONMENT, Category.REFUGEES, Category.UNCATEGORIZED));
    }
}
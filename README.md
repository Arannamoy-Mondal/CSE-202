# Set up javafx For Eclipse
# Help -> Eclipse User Storage -> Eclipse Market Place -> Search -> e(fx)clipse install 
# Set up JavaFx for IntelliJ student pack account without maven:
``
Step 1: File -> New -> Project -> Java -> "Select JDK" -> 
``

``
Step 2: File -> File Structure -> Libraries -> + "Add All JavaFx JDK Files" ->
``

``
Step 3: Current File -> Edit Configurations -> Edit COnfiguration Templates -> Application -> Modify Options -> Add VM Options -> "1st dropdown box select Oracle JDK " -> Add VM Arguments
``
# Add VM Arguments:
```txt
--module-path "path\openjfx-23.0.1_windows-x64_bin-sdk\javafx-sdk-23.0.1\lib" --add-modules javafx.controls,javafx.fxml
```

# If FXML file not create, then " Install new software " and add software. Links ( N.B. Please check the link is it vulnerable or not? You can simply chcek it by virus total. Do it at own risk. ):
```txt
https://download.eclipse.org/justj/?file=efxclipse/updates-nightly/site
```
```txt
https://download.eclipse.org/efxclipse/updates-nightly/site/
```


# File structure of IntelliJ vs Eclipse:

```
┌─────────┬─────────────────┬──────────────────┐
│ (index) │ Eclipse         │ IntelliJ_IDEA    │
├─────────┼─────────────────┼──────────────────┤
│ 0       │ 'Workspace'     │ 'Project'        │
│ 1       │ 'Project'       │ 'Module'         │
│ 2       │ 'Facet'         │ 'Facet'          │
│ 3       │ 'Library'       │ 'Library'        │
│ 4       │ 'JRE'           │ 'SDK'            │
│ 5       │ 'Path-Variable' │ 'Class-Variable' │
└─────────┴─────────────────┴──────────────────┘
```

# Link two dependecies on IntelliJ:
`
File -> Project Structure -> Modules -> " Add Module by + sign " -> Import Module -> Choose One ( Prefer Create module from existing source ) -> "Overwritten/ Reuse: Choose Reuse " -> 
`

`File -> Project Structure -> Modules -> Dependencies " From Source Path Dependecies " -> + -> Module Dependency -> Select Module ->`


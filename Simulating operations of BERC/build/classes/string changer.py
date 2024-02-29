import os

def change_string(directory):
  """Change the given string in both file contents and filenames within the directory.

  Args:
    directory: The directory to search for files.
  """

  search_string = input("Enter the string to search for: ")
  replace_string = input("Enter the string to replace with: ")

  for file in os.listdir(directory):
    old_path = os.path.join(directory, file)
    if os.path.isfile(old_path):
      new_filename = file.replace(search_string, replace_string)
      new_path = os.path.join(directory, new_filename)

      # Rename the file
      os.rename(old_path, new_path)

      # Change the content of the file
      with open(new_path, "r", encoding="utf-8") as f:  # Ensure consistent encoding
        content = f.read()
        content = content.replace(search_string, replace_string)
      with open(new_path, "w", encoding="utf-8") as f:
        f.write(content)

directory = "C:/Users/Reaper/Documents/NetBeansProjects/Simulating operations of BERC/src"

if os.path.isdir(directory):
  change_string(directory)
else:
  print("The directory does not exist.")

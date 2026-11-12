
from pathlib import Path
import re

gradle_file = Path("app/build.gradle.kts")
content = gradle_file.read_text(encoding="utf-8")

code_pattern = r'versionCode\s*=\s*(\d+)'
name_pattern = r'versionName\s*=\s*"(\d+)\.(\d+)"'

code_match = re.search(code_pattern, content)
name_match = re.search(name_pattern, content)

if not code_match or not name_match:
    raise SystemExit("Не удалось найти versionCode или versionName")

new_code = int(code_match.group(1)) + 1
major, minor = map(int, name_match.groups())
new_name = f"{major}.{minor + 1}"

content = re.sub(
    code_pattern,
    f"versionCode = {new_code}",
    content,
    count=1
)

content = re.sub(
    name_pattern,
    f'versionName = "{new_name}"',
    content,
    count=1
)

gradle_file.write_text(content, encoding="utf-8")

print(f"Новая версия: versionCode={new_code}, versionName={new_name}")
